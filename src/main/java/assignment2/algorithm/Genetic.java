package assignment2.algorithm;

import assignment2.models.Individual;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Genetic {

    private double crossoverRate;
    private double mutationRate;
    private boolean elitism;
    private int populationSize;
    private int amountOfIterations;
    private Function<Individual, Double> computeFitness;

    private Map<Individual, Double> populationWithFitness = new HashMap<>();

    public Genetic(double crossoverRate, double mutationRate, boolean elitism, int populationSize, int amountOfIterations, Function<Individual, Double> computeFitness) {
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.elitism = elitism;
        this.populationSize = populationSize;
        this.amountOfIterations = amountOfIterations;
        this.computeFitness = computeFitness;
    }

    public Individual run() {
        List<Individual> currentPopulation = initPopulation();

        for (int generation = 0; generation < amountOfIterations; generation++) {
            List<Double> fitnesses = currentPopulation.stream().map(individual -> computeFitness.apply(individual)).collect(Collectors.toList());

            double sumFitness = 0.0;

            for (int i = 0; i < currentPopulation.size(); i++) {
                populationWithFitness.put(currentPopulation.get(i), fitnesses.get(i));
                sumFitness += fitnesses.get(i);
            }

            List<Individual> nextPopulation = new ArrayList<>();

            int startIndex;
            if (elitism) {
                startIndex = 1;
                nextPopulation.set(0, getBestIndividual());
            } else {
                startIndex = 0;
            }

            Collection<Individual> parents = selectTwoParent(populationWithFitness, sumFitness);

            for (int i = startIndex; i < populationSize; i++) {
                Collection<Individual> offspring;
                if (Math.random() < crossoverRate) {
                    offspring = getChildren(parents);
                } else {
                    offspring = parents;
                }

                Individual[] offspringArray = (Individual[]) offspring.toArray();
                nextPopulation.set(i, offspringArray[0].mutate(mutationRate));
                if (i < populationSize) {
                    nextPopulation.set(i, offspringArray[1].mutate(mutationRate));
                }
            }

            currentPopulation = nextPopulation;
        }

        List<Double> finalFitnesses = currentPopulation.stream().map(individual -> computeFitness.apply(individual)).collect(Collectors.toList());
        return getBestIndividual(currentPopulation, finalFitnesses);
    }

    private Collection<Individual> getChildren(Collection<Individual> parents) {
        if (parents.size() != 2) {
            throw new IllegalArgumentException("There are more or less then 2 parents");
        }

        return parents.stream().map(parent -> parent.breed(parent)).collect(Collectors.toCollection(HashSet::new));
    }

    private List<Individual> initPopulation() {
        Random r = new Random();

        List<Individual> initialPopulation = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            initialPopulation.add(new Individual(r.nextInt(32)));
        }
        return initialPopulation;
    }

    private Individual getBestIndividual() {
        Individual bestIndividual = null;
        Double bestFitness = 0.0;

        for (Individual individual : populationWithFitness.keySet()) {
            Double fitness = populationWithFitness.get(individual);

            if (fitness > bestFitness) {
                bestIndividual = individual;
                bestFitness = fitness;
            }
        }

        return bestIndividual;
    }

    private Individual getBestIndividual(List<Individual> currentPopulation, List<Double> finalFitnesses) {
        Individual bestIndividual = null;
        Double bestFitness = 0.0;

        for (int i = 0; i < finalFitnesses.size(); i++) {
            Double fitness = finalFitnesses.get(i);

            if (fitness > bestFitness) {
                bestFitness = fitness;
                bestIndividual = currentPopulation.get(i);
            }
        }

        return bestIndividual;
    }

    private Collection<Individual> selectTwoParent(Map<Individual, Double> populationWithFitness, double sumFitness) {
        Individual parent1 = selectParent(populationWithFitness, sumFitness, null);
        Individual parent2 = selectParent(populationWithFitness, sumFitness, parent1);

        return Arrays.asList(parent1, parent2);
    }

    private Individual selectParent(Map<Individual, Double> populationWithFitness, double sumFitness, Individual otherParent) {
        double sum = 0;
        double random = Math.random() * sumFitness;
        Individual last = null;

        for (Individual individual : populationWithFitness.keySet()) {
            if (individual == otherParent) {
                continue;
            }

            sum += populationWithFitness.get(individual) / sumFitness;
            last = individual;

            if (random < sum) {
                return individual;
            }
        }
        return last;
    }
}
