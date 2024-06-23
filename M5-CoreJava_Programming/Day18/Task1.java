/*Day-18 Task 1:
Bit Manipulation Basics
Create a function that counts the number of set bits (1s) in the binary
representation of an integer. Extend this to count the total number of set 
bits in all integers from 1 to n.
*/

//Solution:

public class CountSetBits {

    // Function to count the number of set bits in the binary representation of an integer
    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    // Function to count the total number of set bits in all integers from 1 to n
    public static int countTotalSetBits(int n) {
        int totalSetBits = 0;
        for (int i = 1; i <= n; i++) {
            totalSetBits += countSetBits(i);
        }
        return totalSetBits;
    }

    // Main method for testing
    public static void main(String[] args) {
        int num = 23;
        System.out.println("Number of set bits in " + num + ": " + countSetBits(num));

        int n = 10;
        System.out.println("Total number of set bits from 1 to " + n + ": " + countTotalSetBits(n));
    }
}
