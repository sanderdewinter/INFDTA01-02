import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ClientTest {

    private static List<Client> clients;

    @BeforeClass
    public static void setup() throws IOException {
        long start = System.currentTimeMillis();
        clients = WineDataLoader.loadWineData();
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void testLoadData() {
        Assert.assertNotNull(clients);
    }

}