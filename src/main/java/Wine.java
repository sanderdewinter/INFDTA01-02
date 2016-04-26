import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Wine {
    Vector<Vector<Integer>> vector = new Vector<Vector<Integer>>();

    public Wine(Vector<Vector<Integer>> vector) {
        this.vector = vector;
    }

    @Override
    public String toString() {
        String vector = "";
        String newline = System.getProperty("line.separator");

        for (Vector<Integer> innerVector : this.vector) {
            for (Integer integer : innerVector) {
                vector += integer.toString() + ",";
            }

            vector = vector.substring(0, vector.length() - 1);
            vector += newline;
        }

        return vector;
    }

    public void toCsv() {
        try {
            FileWriter writer = new FileWriter("src/main/resources/export.csv");
            writer.append(toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
