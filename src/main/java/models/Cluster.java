package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Cluster implements IVector {

    private Vector<Integer> centroid;
    private List<Vector<Integer>> points;

    public Cluster(Vector<Integer> centroid) {
        this.centroid = centroid;
        points = new ArrayList<>();
    }

    public Cluster(Vector<Integer> centroid, List<Vector<Integer>> points) {
        this.centroid = centroid;
        this.points = points;
    }

    public Vector<Integer> getCentroid() {
        return centroid;
    }

    public void setCentroid(Vector<Integer> centroid) {
        this.centroid = centroid;
    }

    public List<Vector<Integer>> getPoints() {
        return points;
    }

    public void setPoints(List<Vector<Integer>> points) {
        this.points = points;
    }

    public void addPoint(Vector<Integer> point) {
        points.add(point);
    }

    public void clearCluster() {
        points.clear();
    }

    @Override
    public Vector<Integer> vector() {
        return centroid;
    }
}
