/*Day-15 Task 1: Dijkstra’s Shortest Path Finder
Code Dijkstra’s algorithm to find the shortest path from a start node to 
every other node in a weighted graph with positive weights.
*/


//Solution:

package day15.task1;
import java.util.*;

class Graph {
    private int V;
    private List<List<Node>> adjList;

    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
    }

    public int[] dijkstra(int start) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }

    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        Graph graph = new Graph(V);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 3);
        graph.addEdge(2, 3, 9);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 4);

        int startNode = 0;
        int[] shortestDistances = graph.dijkstra(startNode);

        System.out.println("Shortest distances from node " + startNode + " to every other node:");
        for (int i = 0; i < V; i++) {
            System.out.println("To node " + i + ": " + shortestDistances[i]);
        }
    }
}
