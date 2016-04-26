import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class WineDataLoader {
    public static Wine loadWineData() throws IOException {
        String file = "src/main/resources/WineData.csv";
        BufferedReader in = new BufferedReader(new FileReader(file));

        Vector<Vector<Integer>> vector = new Vector<Vector<Integer>>();

        String line;
        while((line = in.readLine()) != null) {
            String[] item = line.split(",");

            Vector<Integer> rowVector = new Vector<Integer>();
            for (String i : item) {
                rowVector.add(Integer.valueOf(i));
            }

            vector.add(rowVector);
        }

        return new Wine(vector);
    }
}
