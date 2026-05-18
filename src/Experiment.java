public class Experiment {

    public void runTraversals(Graph graph) {

        System.out.println("\nBFS Traversal:");

        long startBFS = System.nanoTime();

        graph.bfs(0);

        long endBFS = System.nanoTime();

        System.out.println("BFS execution time: "
                + (endBFS - startBFS) + " ns");

        System.out.println("\nDFS Traversal:");

        long startDFS = System.nanoTime();

        graph.dfs(0);

        long endDFS = System.nanoTime();

        System.out.println("DFS execution time: "
                + (endDFS - startDFS) + " ns");
    }

    public void runMultipleTests() {

        int[] graphSizes = {10, 30, 100};

        for (int size : graphSizes) {

            Graph graph = new Graph();

            // Add vertices
            for (int i = 0; i < size; i++) {

                graph.addVertex(new Vertex(i));
            }

            // Add edges
            for (int i = 0; i < size; i++) {

                graph.addEdge(i, (i + 1) % size);

                if (i + 3 < size) {

                    graph.addEdge(i, i + 3);
                }

                if (i + 5 < size) {

                    graph.addEdge(i, i + 5);
                }
            }

            System.out.println("\n====================");
            System.out.println("Graph size: " + size);
            System.out.println("====================");

            if (size == 10) {

                graph.printGraph();
            }

            runTraversals(graph);
        }
    }
}