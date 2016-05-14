import algorithm.KMeans;
import junit.framework.Assert;
import models.Client;
import models.Cluster;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ClientTest {

    private static List<Client> clients;
    private static KMeans kMeans;
    private static List<Vector<Integer>> vectorList;

    @BeforeClass
    public static void setup() throws IOException {
        clients = WineDataLoader.loadWineData();
        vectorList = clients.stream().map(Client::getWine).collect(Collectors.toList());

        kMeans = new KMeans(vectorList);
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
}