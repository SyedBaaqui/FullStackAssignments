/*Day16-Task3:
Naive Pattern Search
Implement the naive pattern searching algorithm to find all occurrences
of a pattern within a given text string. Count the number of comparisons
made during the search to evaluate the efficiency of the algorithm.
*/

//Solution:

package day16.task3;

public class NaivePatternSearch {
    public static int naivePatternSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int comparisons = 0;

        // Iterate through the text
        for (int i = 0; i <= n - m; i++) {
            int j;

            // Check for pattern match starting from position i
            for (j = 0; j < m; j++) {
                comparisons++; // Counting the number of comparisons
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            // If the inner loop finished without a break, then a pattern match is found
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }

        return comparisons;
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";
        int comparisons = naivePatternSearch(text, pattern);
        System.out.println("Number of comparisons: " + comparisons);
    }
}
