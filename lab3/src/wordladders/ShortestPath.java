package wordladders;
import java.util.HashSet;
import java.util.Set;

public class ShortestPath {
	public static int shortestPath(SimpleGraph g,
	        String source, String dest) {
	        Set<String> visited = new HashSet<String>();
	        Set<String> actLevel = new HashSet<String>();
	        int distance = 0;

	        visited.add(source);
	        actLevel.add(source);

	        while (!actLevel.isEmpty()) {
	            Set<String> nextLevel = new HashSet<String>();
	            for (String s : actLevel) {
	                if (s.equals(dest)) {
	                    return distance;
	                }
	                for (String n : g.adjacentTo(s)) {
	                    if (!visited.contains(n)) {
	                        visited.add(n);
	                        nextLevel.add(n);
	                    }
	                }
	            }
	            distance++;
	            actLevel = nextLevel;
	        }
	        return -1;
	}

}
