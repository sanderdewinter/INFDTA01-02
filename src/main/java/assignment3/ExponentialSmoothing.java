package assignment3;

import java.util.ArrayList;
import java.util.List;

public class ExponentialSmoothing {

    private List<Integer> data;
    private List<Double> ses;
    private List<Double> des;

    private double a;
    private double b;

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

        for (int i = 0; i < data.size(); i++) {
            if (i == 0) {
                double average = getMovingAverage(data, 12);
                ses.add(average);
                continue;
            }

            double result = a * data.get(i - 1) + (1 - a) * ses.get(i - 1);
            ses.add(result);
        }

        return ses;
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
}
