package models;

import java.util.List;
import java.util.Vector;

public class Cluster {

    private Vector<Integer> centroid;
    private List<Vector<Integer>> points;

    public Cluster(Vector<Integer> centroid) {
        this.centroid = centroid;
    }

    public Cluster(Vector<Integer> centroid, List<Vector<Integer>> points) {
        this.centroid = centroid;
        this.points = points;
    }

    public List<Vector<Integer>> getPoints() {
        return points;
    }

    public Vector<Integer> getCentroid() {
        return centroid;
    }
}
