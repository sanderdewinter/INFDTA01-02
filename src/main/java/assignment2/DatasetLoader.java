package assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatasetLoader {

    private static final String file = "src/main/resources/SwordForcasting.csv";

    public static List<Integer> getData() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));

        List<Integer> result = new ArrayList<>();

        String line;
        while ((line = in.readLine()) != null) {
            result.add(Integer.valueOf(line));
        }

        return result;
    }
}
