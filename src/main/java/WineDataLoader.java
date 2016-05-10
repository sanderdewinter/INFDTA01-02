import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WineDataLoader {
    public static List<Client> loadWineData() throws IOException {
        String file = "src/main/resources/WineData.csv";
        BufferedReader in = new BufferedReader(new FileReader(file));

        List<Client> clients = new ArrayList<>();

        String line;
        boolean firstRow = true;
        while ((line = in.readLine()) != null) {
            String[] item = line.split(",");

            int i = 0;
            for (String offer : item) {
                Client client;

                if (firstRow) {
                    client = new Client();
                } else {
                    client = clients.get(i);
                }

                client.getWine().add(Integer.valueOf(offer));

                if (firstRow) {
                    clients.add(i, client);
                } else {
                    clients.set(i, client);
                }

                i++;
            }
            firstRow = false;
        }

        return clients;
    }
}
