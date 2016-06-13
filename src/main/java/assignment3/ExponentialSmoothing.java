package assignment3;

import java.util.List;

public class ExponentialSmoothing {

    private List<Integer> data;
    private double a;
    private double b;

    public ExponentialSmoothing(List<Integer> data, double a) {
        this.data = data;
        this.a = a;
    }

    public ExponentialSmoothing(List<Integer> data, double a, double b) {
        this.data = data;
        this.a = a;
        this.b = b;
    }


}
