/*
Day-17 Task 4: Rabin-Karp Substring Search
Implement the Rabin-Karp algorithm for substring search using a 
rolling hash. Discuss the impact of hash collisions on the algorithm's 
performance and how to handle them.
*/

//Solution:
package day17.task4;
import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {
    private static final int PRIME = 101; // A prime number used for hashing

    public static List<Integer> search(String text, String pattern) {
        List<Integer> matches = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();
        long patternHash = calculateHash(pattern, m);
        long textHash = calculateHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && checkEquals(text, pattern, i, i + m - 1)) {
                matches.add(i);
            }
            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }
        return matches;
    }

    private static long calculateHash(String str, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private static long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patternLength) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash /= PRIME;
        newHash += str.charAt(newIndex) * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    private static boolean checkEquals(String text, String pattern, int start, int end) {
        if (text.substring(start, end + 1).equals(pattern)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        List<Integer> matches = search(text, pattern);

        if (!matches.isEmpty()) {
            System.out.println("Pattern found at index:");
            for (int index : matches) {
                System.out.println(index);
            }
        } else {
            System.out.println("Pattern not found");
        }
    }
}

/*Discussion:

1. Impact of Hash Collisions:
   - Hash collisions occur when two different substrings have the same hash value. In the Rabin-Karp algorithm, hash collisions can lead to false positives, where the algorithm mistakenly identifies a substring as a match when it is not.
   - Hash collisions can impact the efficiency and accuracy of the Rabin-Karp algorithm, especially when the prime number used for hashing is small or when the hash function does not distribute hash values evenly across substrings.

2. Handling Hash Collisions:
   - One common approach to handle hash collisions in the Rabin-Karp algorithm is to use a more robust hash function that minimizes collisions. This may involve choosing a larger prime number for hashing or using a different hash function altogether.
   - Additionally, if a hash collision is detected during substring comparisons, the algorithm can perform a secondary check to verify the equality of the substrings character by character to ensure accuracy.

3. Choosing a Prime Number:
   - The choice of the prime number used for hashing is crucial in minimizing hash collisions. A larger prime number generally leads to fewer collisions,
    but it also increases the computation time.
   - It's essential to select a prime number that is large enough to minimize collisions while still maintaining computational efficiency.

4. Performance Considerations:
   - The performance of the Rabin-Karp algorithm can be significantly affected by hash collisions, especially in scenarios with a high likelihood of collisions or with large datasets.
   - Careful consideration should be given to the choice of hash function and prime number to balance performance and accuracy.Additionally, 
   optimizing the algorithm's implementation can help mitigate the impact of collisions on performance.*/