package assignment2;

public class Assignment2 {

    public static void main(String[] args){
        double crossoverRate = Double.parseDouble(args[0]);
        double mutationRate = Double.parseDouble(args[1]);
        boolean elitism = Boolean.parseBoolean(args[2]);
        int populationSize = Integer.parseInt(args[3]);
        int numIterations = Integer.parseInt(args[4]);
        if(populationSize <2){
            return;
        }

    }


}
