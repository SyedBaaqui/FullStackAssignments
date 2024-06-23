/*
Day-19 Task 2: 
Traveling Salesman Problem
Create a function int FindMinCost(int[,] graph)
that takes a 2D array representing the graph where graph[i][j] is
the cost to travel from city i to city j. The function should return
the minimum cost to visit all cities and return to the starting city. 
Use dynamic programming for this solution.
*/

//Solution

public class TravelingSalesman {

    // Function to find the minimum cost to visit all cities and return to the starting city
    public static int findMinCost(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[1 << n][n]; // dp[mask][i] stores the minimum cost to visit cities represented by mask and end at city i

        // Initialize dp table
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Base case: when there is only one city
        dp[1][0] = 0;

        // Iterate through all possible subsets of cities
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // If city i is included in the subset represented by mask
                    for (int j = 0; j < n; j++) {
                        if ((mask & (1 << j)) != 0 && i != j) { // If city j is also included and i is not equal to j
                            dp[mask][i] = Math.min(dp[mask][i], dp[mask ^ (1 << i)][j] + graph[j][i]);
                        }
                    }
                }
            }
        }

        // Find the minimum cost to return to the starting city
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[(1 << n) - 1][i] != Integer.MAX_VALUE && graph[i][0] != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, dp[(1 << n) - 1][i] + graph[i][0]);
            }
        }

        return minCost;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("Minimum cost to visit all cities and return to the starting city: " + findMinCost(graph));
    }
}
