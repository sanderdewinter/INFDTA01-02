package algorithm;

import models.Cluster;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public class KMeans {

    private List<Vector<Integer>> points;
    private List<Cluster> clusters;

    public KMeans(List<Vector<Integer>> points) {
        this.points = points;
    }

    public Double getEuclideanDistance(Vector<Integer> v1, Vector<Integer> v2) {
        double distance = 0.0;
        
        for (int i = 0; i < v1.size(); i++) {
            distance += Math.pow(v2.get(i) - v1.get(i), 2);
        }

        return Math.sqrt(distance);
    }

    public void initCentroidsByRandom(int amountOfClusters) {
        List<Cluster> clusterCenter = new Vector<>();
        for (int i = 0; i < amountOfClusters; i++) {
            int random = new Random().nextInt(points.size());
            clusterCenter.add(new Cluster(points.get(random)));
        }

        this.clusters = clusterCenter;
    }

    public List<Vector<Integer>> getPoints() {
        return points;
    }

    public List<Cluster> getClusters() {
        return clusters;
    }
}
