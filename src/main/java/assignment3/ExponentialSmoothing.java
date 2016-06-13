package assignment3;

import java.util.ArrayList;
import java.util.List;

class ExponentialSmoothing {

    private List<Integer> data;
    private List<Double> ses;
    private List<Double> des;

    private double a;
    private double b;

    private double sesError;

    public ExponentialSmoothing(List<Integer> data, double a) {
        this.data = data;
        this.a = a;
        this.ses = new ArrayList<>();
    }

    public ExponentialSmoothing(List<Integer> data, double a, double b) {
        this.data = data;
        this.a = a;
        this.b = b;
        this.ses = new ArrayList<>();
        this.des = new ArrayList<>();
    }

    public List<Double> simpleExponentialSmoothing() {
        ses.clear();
        sesError = 0;

        for (int i = 0; i < data.size(); i++) {
            if (i == 0) {
                double average = getMovingAverage(data, 12);
                ses.add(average);
                continue;
            }

            double result = a * data.get(i - 1) + (1 - a) * ses.get(i - 1);
            ses.add(result);

            double error = Math.pow(data.get(i) - result, 2);
            sesError += error;
        }

        sesError = sesError / (data.size() - 1);

        return ses;
    }

    public double getBestSesSmoothingFactor() {
        double bestSmoothingFactor = 0.0;
        double lowestSesError = 99999;

        for (double currentSmoothingFactor = 0.05; currentSmoothingFactor < 1; currentSmoothingFactor += 0.05) {
            simpleExponentialSmoothing();

            if (sesError < lowestSesError) {
                lowestSesError = sesError;
                bestSmoothingFactor = currentSmoothingFactor;
            }
        }

        return bestSmoothingFactor;
    }

    private double getMovingAverage(List<Integer> data, int k) {
        if (k > data.size()) {
            throw new IllegalArgumentException("k cannot be bigger than the size of the data");
        }

        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += data.get(i);
        }

        return sum / k;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }
}
