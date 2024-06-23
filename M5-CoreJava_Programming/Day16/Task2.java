/* Day-16 Task 2: 
String Operations
Write a method that takes two strings, concatenates them, reverses the
result, and then extracts the middle substring of the given length. 
Ensure your method handles edge cases, such as an empty string or a 
substring length larger than the concatenated string.
*/

//Solution:

package day16.task2;
public class StringUtil {
    public static String getMiddleSubstring(String str1, String str2, int length) {
        // Concatenate the strings
        String concatenated = str1.concat(str2);

        // Reverse the concatenated string
        StringBuilder reversed = new StringBuilder(concatenated).reverse();

        // Handle edge case of empty string
        if (reversed.length() == 0) {
            return "";
        }

        // Ensure length is not larger than the concatenated string
        length = Math.min(length, reversed.length());

        // Calculate the start index of the middle substring
        int startIndex = (reversed.length() - length) / 2;

        // Extract the middle substring
        return reversed.substring(startIndex, startIndex + length);
    }

    public static void main(String[] args) {
        // Test cases
        String str1 = "Hello";
        String str2 = "World";
        int length = 4;
        System.out.println(getMiddleSubstring(str1, str2, length)); // Expected output: "lroW"

        str1 = "";
        str2 = "Test";
        length = 5;
        System.out.println(getMiddleSubstring(str1, str2, length)); // Expected output: "tseT"

        str1 = "Open";
        str2 = "AI";
        length = 10;
        System.out.println(getMiddleSubstring(str1, str2, length)); // Expected output: "nepo" (reversed of "OpenAI")
    }
}
