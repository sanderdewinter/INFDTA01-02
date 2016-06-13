package assignment2;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class Assignment2Test {

    static List<Integer> data;

    @BeforeClass
    public static void setUp() throws IOException {
        data = DatasetLoader.getData();
    }

    @Test
    public void testDataset() {
        assertNotNull(data);
        assertTrue(data.size() > 10);
    }
}