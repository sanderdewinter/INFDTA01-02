import models.Client;
import models.Cluster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WineDataService {
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

                client.getWine().add(Double.valueOf(offer));

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

    public static void printClusters(List<Cluster> clusters) {
        System.out.println("");

        for (int i = 0; i < clusters.size(); i++) {
            Cluster cluster = clusters.get(i);

            if (cluster.getPoints().size() > 0) {
                TreeMap<Integer, Integer> result = new TreeMap<>();

                for (Vector<Double> vector : cluster.getPoints()) {
                    for (int j = 0; j < vector.size(); j++) {
                        Double value = vector.get(j);

                        if (value == 1.0) {
                            if (result.containsKey(j)) {
                                result.put(j, result.get(j) + 1);
                            } else {
                                result.put(j, 1);
                            }
                        }
                    }
                }

                SortedSet<Map.Entry<Integer, Integer>> entries = entriesSortedByValues(result);
                for (Map.Entry<Integer, Integer> entry : entries) {
                    System.out.println("OFFER: " + (entry.getKey() + 1) + " -> bought " + entry.getValue() + " times");
                }

            } else {
                System.out.println("Cluster: " + i + " has no points.");
            }

            System.out.println("");
            System.out.println("-------------------------------");
            System.out.println("");
        }
    }

    private static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>(
                (Comparator<Map.Entry<K, V>>) (e2, e1) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
