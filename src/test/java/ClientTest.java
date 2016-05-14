import algorithm.KMeans;
import junit.framework.Assert;
import models.Client;
import models.Cluster;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ClientTest {

    private static List<Client> clients;
    private static KMeans kMeans;

    @BeforeClass
    public static void setup() throws IOException {
        clients = WineDataLoader.loadWineData();
        kMeans = new KMeans(clients);
    }

    @Test
    public void testLoadData() {
        Assert.assertNotNull(clients);
    }

    @Test
    public void testInitCentroidsByRandom() {
        kMeans.initCentroidsByRandom(3);
        List<Cluster> clusterCenter = kMeans.getClusters();
        Assert.assertNotNull(clusterCenter);
    }

    @Test
    public void testKMeansCalculate() {
        kMeans.initCentroidsByRandom(3);
        kMeans.calculate();
        List<Cluster> clusters = kMeans.getClusters();
        Assert.assertNotNull(clusters);
    }
}