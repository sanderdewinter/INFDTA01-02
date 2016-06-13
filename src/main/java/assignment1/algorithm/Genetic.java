package assignment1.algorithm;

public class Genetic {

    private double crossoverRate;
    private double mutationRate;
    private boolean elitism;
    private int populiationSize;
    private int amountOfIterations;

    public Genetic(double crossoverRate, double mutationRate, boolean elitism, int populiationSize, int amountOfIterations) {
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.elitism = elitism;
        this.populiationSize = populiationSize;
        this.amountOfIterations = amountOfIterations;
    }
}
