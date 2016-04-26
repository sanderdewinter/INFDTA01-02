import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class WineTest {

    private static Wine wine;

    @BeforeClass
    public static void setup() throws IOException {
        wine = WineDataLoader.loadWineData();
    }

    @Test
    public void testLoadData() {
        Assert.assertNotNull(wine);
    }

}