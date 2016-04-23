package wordladders;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GraphCreator implements SimpleGraph {
    private Map<String, Set<String>> graph = new HashMap<String, Set<String>>();

    public GraphCreator(String fileName, GraphStrategy graphStrat) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't open file: " + fileName);
            System.exit(1);
        }

        while (scan.hasNext()) {
            graph.put(scan.next(), new HashSet<String>());
        }

        for (String word1 : graph.keySet()) {
            for (String word2 : graph.keySet()) {
                if (graphStrat.adjacent(word1, word2)) {
                    graph.get(word1).add(word2);
                }
            }
        }
        scan.close();
    }

    public Set<String> adjacentTo(String s) {
        return graph.get(s);
    }
}
