import java.util.*;

public class WeightedGraph {

    private Map<Integer, ArrayList<WeightedEdge>> adjacencyList;

    public WeightedGraph() {

        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {

        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source,
                        int destination,
                        int weight) {

        adjacencyList.get(source)
                .add(new WeightedEdge(destination, weight));

        adjacencyList.get(destination)
                .add(new WeightedEdge(source, weight));
    }

    public void printGraph() {

        System.out.println("Weighted Graph:");

        for (int vertex : adjacencyList.keySet()) {

            System.out.println(vertex
                    + " -> "
                    + adjacencyList.get(vertex));
        }
    }

    public void dijkstra(int start) {

        int size = adjacencyList.size();

        int[] distance = new int[size];

        boolean[] visited = new boolean[size];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        for (int i = 0; i < size - 1; i++) {

            int currentVertex =
                    findMinDistance(distance, visited);

            visited[currentVertex] = true;

            for (WeightedEdge edge :
                    adjacencyList.get(currentVertex)) {

                int neighbor = edge.getDestination();

                int weight = edge.getWeight();

                if (!visited[neighbor]
                        && distance[currentVertex]
                        != Integer.MAX_VALUE
                        && distance[currentVertex] + weight
                        < distance[neighbor]) {

                    distance[neighbor] =
                            distance[currentVertex] + weight;
                }
            }
        }

        printDistances(start, distance);
    }

    private int findMinDistance(int[] distance,
                                boolean[] visited) {

        int min = Integer.MAX_VALUE;

        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {

            if (!visited[i]
                    && distance[i] < min) {

                min = distance[i];

                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printDistances(int start,
                                int[] distance) {

        System.out.println(
                "\nDijkstra shortest paths from vertex "
                        + start + ":");

        for (int i = 0; i < distance.length; i++) {

            System.out.println(
                    "To vertex "
                            + i
                            + " = "
                            + distance[i]);
        }
    }
}