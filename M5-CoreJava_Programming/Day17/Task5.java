/*
Day-17 Task 5: 
Boyer-Moore Algorithm Application
Use the Boyer-Moore algorithm to write a function that finds the last occurrence 
of a substring in a given string and returns its index. Explain why this algorithm
can outperform others in certain scenarios.
*/

//Solution:
package day17.task5;
public class BoyerMooreLastOccurrence {
    private static final int NO_OF_CHARS = 256;

    public static int findLastOccurrence(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] badChar = badCharHeuristic(pattern);

        int s = 0; // Shift of the pattern with respect to text
        while (s <= n - m) {
            int j = m - 1; // Index of the last character in the pattern

            // Keep reducing index j of pattern while characters of pattern and text are matching
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j))
                j--;

            // If the pattern is found, return its starting index in text
            if (j < 0) {
                return s;
            } else {
                // Shift the pattern based on the bad character rule
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
        }
        return -1; // Pattern not found
    }

    private static int[] badCharHeuristic(String pattern) {
        int[] badChar = new int[NO_OF_CHARS];
        int m = pattern.length();

        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++)
            badChar[i] = -1;

        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < m; i++)
            badChar[(int) pattern.charAt(i)] = i;

        return badChar;
    }

    public static void main(String[] args) {
        String text = "ABAAABCD";
        String pattern = "ABC";
        int lastOccurrenceIndex = findLastOccurrence(text, pattern);
        if (lastOccurrenceIndex != -1) {
            System.out.println("Last occurrence of pattern found at index: " + lastOccurrenceIndex);
        } else {
            System.out.println("Pattern not found in text");
        }
    }
}


/*
Explanation:

Boyer-Moore Algorithm:
The Boyer-Moore algorithm is based on two heuristics: the bad character rule and the good suffix rule. It works by comparing the pattern with the text from right to left and shifting the pattern based on mismatches and pre-computed tables.

Finding Last Occurrence:
In this implementation, we modify the algorithm to find the last occurrence of the pattern in the text. We start searching from the end of the text and move towards the beginning.
We shift the pattern based on the bad character rule to ensure that we skip as many characters as possible in the text when a mismatch occurs, thereby reducing the number of comparisons.

Performance:
The Boyer-Moore algorithm can outperform other substring search algorithms, especially in scenarios where the pattern length is larger and the alphabet size is relatively small.
Its efficiency comes from the fact that it skips characters based on pre-computed tables (bad character and good suffix), which allows it to perform fewer comparisons compared to other algorithms like naive or KMP.
Additionally, by starting the search from the end of the text, it can quickly skip large portions of the text when mismatches occur, further improving its performance.


*/