import java.util.*;

public class Graph {

    private Map<Integer, ArrayList<Integer>> adjacencyList;

    public Graph() {

        adjacencyList = new HashMap<>();
    }

    // Add new vertex
    public void addVertex(Vertex vertex) {

        adjacencyList.putIfAbsent(vertex.getId(), new ArrayList<>());
    }

    // Add edge
    public void addEdge(int source, int destination) {

        adjacencyList.get(source).add(destination);

        // Undirected graph
        adjacencyList.get(destination).add(source);
    }

    // Print graph
    public void printGraph() {

        System.out.println("Graph structure:");

        for (int vertex : adjacencyList.keySet()) {

            System.out.println(vertex + " -> " + adjacencyList.get(vertex));
        }
    }

    // Breadth-First Search
    public void bfs(int startVertex) {

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        visited.add(startVertex);

        queue.add(startVertex);

        while (!queue.isEmpty()) {

            int currentVertex = queue.poll();

            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList.get(currentVertex)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    // Depth-First Search
    public void dfs(int startVertex) {

        Set<Integer> visited = new HashSet<>();

        dfsHelper(startVertex, visited);

        System.out.println();
    }

    private void dfsHelper(int vertex, Set<Integer> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {

            if (!visited.contains(neighbor)) {

                dfsHelper(neighbor, visited);
            }
        }
    }
}