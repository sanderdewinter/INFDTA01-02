package assignment2;

import assignment2.models.Individual;
import org.junit.Test;

import java.util.function.Function;

public class Assignment2Test {

    public final Function<Individual, Double> aFakeProblem = b -> {
        int x = b.getByte().intValue();
        return -1 * Math.pow(x, 2) + 7 * x;
    };

    @Test
    public void test() {
        Individual individual = new Individual(2);
        Individual individual2 = new Individual(9);

        System.out.println(individual.getByteString());
        System.out.println(individual2.getByteString());

    }
}