package maxflow;

public class TestMaxFlow {

    public static void main(String[] args) {
        MaxFlow maxFlow1 = new MaxFlow("edaf25-workspace/lab5/small.txt");
        MaxFlow maxFlow2 = new MaxFlow("edaf25-workspace/lab5/sixnodes.txt");
        MaxFlow maxFlow3 = new MaxFlow("edaf25-workspace/lab5/rail.txt");

        System.out.println("Max flow: " + maxFlow1.maxFlow());
        System.out.println("Max flow: " + maxFlow2.maxFlow());
        System.out.println("Max flow: " + maxFlow3.maxFlow());
    }
}