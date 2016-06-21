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

    public void run() {
        List<Individual> currentPopulation = initPopulation();

        for (int generation = 0; generation < amountOfIterations; generation++) {
            List<Double> fitnesses = currentPopulation.stream().map(individual -> computeFitness.apply(individual)).collect(Collectors.toList());

            List<Individual> nextPopulation = new ArrayList<>();

            int startIndex;
            if (elitism) {
                startIndex = 1;

                for (int i = 0; i < currentPopulation.size(); i++) {
                    populationWithFitness.put(currentPopulation.get(i), fitnesses.get(i));
                }

                Individual bestIndividual = getBestIndividual();
                nextPopulation.set(0, bestIndividual);
            } else {
                startIndex = 0;
            }

            selectTwoParents(currentPopulation, fitnesses);
        }
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

    private void selectTwoParents(List<Individual> currentPopulation, List<Double> fitnesses) {
        Collection collection = new HashSet();


    }
}
