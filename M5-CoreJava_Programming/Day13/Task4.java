/*Day-13 Task 4: 
Graph Edge Addition Validation
Given a directed graph, write a function that adds an edge between two nodes and 
then checks if the graph still has no cycles. If a cycle is created, 
the edge should not be added.
*/

//Solution:
package day13.task4;
import java.util.*;

public class DirectedGraph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list representation of the graph

    public DirectedGraph(int V) {
        this.V = V;
        this.adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Function to add an edge between two nodes
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    // DFS function to check if a cycle is present starting from the given vertex
    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
        if (!visited[v]) {
            visited[v] = true;
            recStack[v] = true;

            for (int neighbor : adj.get(v)) {
                if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recStack)) {
                    return true;
                } else if (recStack[neighbor]) {
                    return true;
                }
            }
        }
        recStack[v] = false; // Backtrack
        return false;
    }

    // Function to check if adding an edge between two nodes creates a cycle
    public boolean hasCycle(int u, int v) {
        // Add the edge between u and v
        adj.get(u).add(v);

        // Perform DFS from each vertex to check for cycles
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                // Remove the edge if it creates a cycle
                adj.get(u).remove(adj.get(u).size() - 1);
                return true;
            }
        }

        // Remove the edge if it doesn't create a cycle
        adj.get(u).remove(adj.get(u).size() - 1);
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        // Adding this edge will create a cycle
        System.out.println("Adding edge (3, 0) creates a cycle: " + graph.hasCycle(3, 0));
        // Adding this edge will not create a cycle
        System.out.println("Adding edge (3, 1) creates a cycle: " + graph.hasCycle(3, 1));
    }
}

