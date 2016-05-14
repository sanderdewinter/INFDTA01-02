package algorithm;

import models.Cluster;
import models.IVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class KMeans {

    private List<? extends IVector> points;
    private List<Cluster> clusters;

    public KMeans(List<? extends IVector> points) {
        this.points = points;
        clusters = new ArrayList<>();
    }

    public void calculate() {
        boolean isChanged = true;
        int i = 0;

        while (isChanged && i < 100) {
            clusters.forEach(Cluster::clearCluster);
            isChanged = false;

            for (IVector point : points) {
                double smallestDistance = 99.9;
                Cluster closestCluster = null;

                for (Cluster cluster : clusters) {
                    Double euclideanDistance = getEuclideanDistance(cluster.getCentroid(), point.vector());

                    if (smallestDistance > euclideanDistance) {
                        smallestDistance = euclideanDistance;
                        closestCluster = cluster;
                        isChanged = true;
                    }
                }

                if (closestCluster != null) {
                    closestCluster.addPoint(point.vector());
                }
            }
            i++;
        }
    }

    public Double getEuclideanDistance(Vector<Integer> v1, Vector<Integer> v2) {
        double distance = 0.0;
        
        for (int i = 0; i < v1.size(); i++) {
            distance += Math.pow(v2.get(i) - v1.get(i), 2);
        }

        return Math.sqrt(distance);
    }

    public void initCentroidsByRandom(int amountOfClusters) {
        clusters.clear();
        List<Cluster> clusterCenter = new Vector<>();
        for (int i = 0; i < amountOfClusters; i++) {
            int random = new Random().nextInt(points.size());
            clusterCenter.add(new Cluster(points.get(random).vector()));
        }

        clusters = clusterCenter;
    }

    public List<? extends IVector> getPoints() {
        return points;
    }

    public List<Cluster> getClusters() {
        return clusters;
    }
}
