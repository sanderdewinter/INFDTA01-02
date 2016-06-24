package assignment2;

import assignment2.algorithm.Genetic;
import assignment2.models.Individual;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.Function;

public class Assignment2Test {

    public static final Function<Individual, Double> aFakeProblem = b -> {
        int x = b.getByte().intValue();
        return -1 * Math.pow(x, 2) + 7 * x;
    };

    public static Genetic genetic;

    @BeforeClass
    public static void init() {
        genetic = new Genetic(0.9, 0.05, false, 5, 10, aFakeProblem);
    }

    @Test
    public void test() {
        Individual individual = new Individual(2);
        Individual individual2 = new Individual(9);

        System.out.println(individual.getByteString());
        System.out.println(individual2.getByteString());
        Assert.assertNotNull(individual);
    }

    @Test
    public void testGenetic() {
        Individual result = genetic.run();
        System.out.println(result.getByte());
    }
}