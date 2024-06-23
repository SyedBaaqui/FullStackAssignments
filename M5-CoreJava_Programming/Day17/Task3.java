/*Day-17: Task 3: 
Implementing the KMP Algorithm
Code the Knuth-Morris-Pratt (KMP) algorithm in Java for pattern searching 
which pre-processes the pattern to reduce the number of comparisons. 
Explain how this pre-processing improves the search time compared to the naive 
approach.
*/

//Solution:
package day17.task3;
public class KMPAlgorithm {
    public static void KMPSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Pre-process the pattern to build the prefix array
        int[] lps = computeLPSArray(pattern);

        int i = 0; // Index for text[]
        int j = 0; // Index for pattern[]

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(text, pattern);
    }
}

/*
Explanation:

Pre-processing:
The pre-processing step in the KMP algorithm computes the Longest Prefix Suffix (LPS) array for the pattern. The LPS array stores the length of the longest proper prefix that is also a suffix for each prefix of the pattern. This pre-processing step takes O(m) time, where m is the length of the pattern.

Search Algorithm:
The search algorithm traverses through the text and pattern simultaneously, but with a different strategy than the naive approach.
It compares characters of the text and pattern efficiently by utilizing the information stored in the LPS array. This allows the algorithm to skip unnecessary comparisons.
When a mismatch occurs, instead of going back to the beginning of the pattern in the naive approach, the algorithm utilizes the information from the LPS array to determine the next position to start comparing from.

Comparison:
The naive approach compares each character of the pattern with the corresponding characters in the text, potentially leading to redundant comparisons.
The KMP algorithm, on the other hand, reduces the number of comparisons by efficiently skipping characters in the text based on the information stored in the LPS array.

Time Complexity:
The pre-processing step of computing the LPS array takes O(m) time, where m is the length of the pattern.
The search algorithm then takes O(n) time, where n is the length of the text.
Overall, the KMP algorithm has a time complexity of O(m + n), which is more efficient than the naive approach, especially for large texts and patterns.

*/