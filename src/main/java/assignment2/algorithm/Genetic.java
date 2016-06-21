package assignment2.algorithm;

import assignment2.models.Individual;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Genetic {

    private double crossoverRate;
    private double mutationRate;
    private boolean elitism;
    private int populationSize;
    private int amountOfIterations;
    private Function<Individual, Double> computeFitness;

    public Genetic(double crossoverRate, double mutationRate, boolean elitism, int populationSize, int amountOfIterations, Function<Individual, Double> computeFitness) {
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.elitism = elitism;
        this.populationSize = populationSize;
        this.amountOfIterations = amountOfIterations;
        this.computeFitness = computeFitness;
    }

    public void run() {
        List<Individual> population = initPopulation();

        for (int generation = 0; generation < amountOfIterations; generation++) {
            List<Double> fitnesses = population.stream().map(individual -> computeFitness.apply(individual)).collect(Collectors.toList());

            List<Individual> nextPopulation = new ArrayList<>();
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
}
