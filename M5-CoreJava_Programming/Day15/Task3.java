/*
Day-15 Task 3: Union-Find for Cycle Detection
Write a Union-Find data structure with path compression. 
Use this data structure to detect a cycle in an undirected graph.
*/

//Solution:
Package day15.task3;
import java.util.*;

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}


    public static boolean detectCycle(List<List<Integer>> graph) {
        int n = graph.size();
        UnionFind uf = new UnionFind(n);

        for (int u = 0; u < n; u++) {
            for (int v : graph.get(u)) {
                if (!uf.union(u, v)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2));
        graph.add(Arrays.asList(0, 2));
        graph.add(Arrays.asList(0, 1, 3));
        graph.add(Arrays.asList(2, 4));
        graph.add(Collections.singletonList(3));

        if (detectCycle(graph)) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph doesn't contain a cycle");
        }
    }

