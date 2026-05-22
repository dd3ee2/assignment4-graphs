public class Main {

    public static void main(String[] args) {

        Experiment experiment = new Experiment();

        experiment.runMultipleTests();

        // Bonus Task - Dijkstra Algorithm

        WeightedGraph weightedGraph = new WeightedGraph();

        for (int i = 0; i < 6; i++) {

            weightedGraph.addVertex(i);
        }

        weightedGraph.addEdge(0, 1, 4);
        weightedGraph.addEdge(0, 2, 1);
        weightedGraph.addEdge(1, 3, 1);
        weightedGraph.addEdge(2, 1, 2);
        weightedGraph.addEdge(2, 3, 5);
        weightedGraph.addEdge(3, 4, 3);
        weightedGraph.addEdge(4, 5, 2);

        System.out.println("\n====================");
        System.out.println("BONUS TASK - DIJKSTRA");
        System.out.println("====================");

        weightedGraph.printGraph();

        weightedGraph.dijkstra(0);
    }
}