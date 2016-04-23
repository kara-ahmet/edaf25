package wordladders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void processRequests(GraphStrategy strategy, String wordfile, String infile) {
        SimpleGraph g = new GraphCreator(wordfile, strategy);

        Scanner scan = null;
        try {
            scan = new Scanner(new File(infile));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't open file: " + infile);
            System.exit(1);
        }

        while (scan.hasNext()) {
            String word1 = scan.next();
            String word2 = scan.next();
            System.out.println(ShortestPath.shortestPath(g, word1, word2));
        }
        scan.close();

    }
}
