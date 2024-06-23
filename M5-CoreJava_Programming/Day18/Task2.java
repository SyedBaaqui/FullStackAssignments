
/*Day-18-Task 2: 
Unique Elements Identification
Given an array of integers where every element appears twice except for two, 
write a function that efficiently finds these two non-repeating elements using 
bitwise XOR operations.
*/

//Solution

public class FindNonRepeatingElements {

    // Function to find the two non-repeating elements in an array
    public static int[] findNonRepeating(int[] nums) {
        // Step 1: XOR all elements to get the XOR of the two non-repeating elements
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        // Step 2: Find any set bit in the XOR result
        int rightmostSetBit = xorResult & -xorResult;

        // Step 3: Divide the array into two groups based on the set bit
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                result[0] ^= num; // XOR elements where the bit is not set
            } else {
                result[1] ^= num; // XOR elements where the bit is set
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 2, 3, 3, 1};
        int[] nonRepeating = findNonRepeating(nums);
        System.out.println("The non-repeating elements are: " + nonRepeating[0] + " and " + nonRepeating[1]);
    }
}
