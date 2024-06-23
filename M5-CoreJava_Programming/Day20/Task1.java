/*Day-20:
Task 1: Knapsack Problem
Write a function int Knapsack(int W, int[] weights, int[] values) in 
Java that determines the maximum value of items that can fit into a knapsack 
with a capacity W. The function should handle up to 100 items.
Find the optimal way to fill the knapsack with the given items to achieve
the maximum total value. You must consider that you cannot break items,
but have to include them whole.
*/

//Solution:

public class KnapsackProblem {

    // Function to solve the Knapsack Problem
    public static int knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Find the maximum value
        return dp[n][W];
    }

    // Main method for testing
    public static void main(String[] args) {
        int W = 50; // Capacity of the knapsack
        int[] weights = {10, 20, 30}; // Weights of the items
        int[] values = {60, 100, 120}; // Values of the items

        System.out.println("Maximum value that can be achieved: " + knapsack(W, weights, values));
    }
}
