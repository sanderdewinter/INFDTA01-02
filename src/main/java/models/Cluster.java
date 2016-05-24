package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Cluster implements IVector {

    private Vector<Double> centroid;
    private List<Vector<Double>> points;

    public Cluster(Vector<Double> centroid) {
        this.centroid = centroid;
        points = new ArrayList<>();
    }

    public Cluster(Vector<Double> centroid, List<Vector<Double>> points) {
        this.centroid = centroid;
        this.points = points;
    }

    public Vector<Double> getCentroid() {
        return centroid;
    }

    public void setCentroid(Vector<Double> centroid) {
        this.centroid = centroid;
    }

    public List<Vector<Double>> getPoints() {
        return points;
    }

    public void setPoints(List<Vector<Double>> points) {
        this.points = points;
    }

    public void addPoint(Vector<Double> point) {
        points.add(point);
    }

    public void clearCluster() {
        points.clear();
    }

    @Override
    public Vector<Double> vector() {
        return centroid;
    }
}
