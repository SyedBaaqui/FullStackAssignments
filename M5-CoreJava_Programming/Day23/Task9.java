/*Task 9: Generic Classes and Methods Implement a generic method that swaps the positions of two elements in an array, regardless of their type, and demonstrate its usage with different object types.*/

package com.day23;

import java.util.Arrays;

public class ArrayUtils {

    // Generic method to swap elements in an array
    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid indices provided");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // Demonstration with different object types
        
        // Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swap (Integer): " + Arrays.toString(intArray));
        swap(intArray, 1, 3);
        System.out.println("After swap (Integer): " + Arrays.toString(intArray));

        // String array
        String[] strArray = {"apple", "banana", "cherry"};
        System.out.println("Before swap (String): " + Arrays.toString(strArray));
        swap(strArray, 0, 2);
        System.out.println("After swap (String): " + Arrays.toString(strArray));

        // Double array
        Double[] doubleArray = {1.5, 2.5, 3.5, 4.5};
        System.out.println("Before swap (Double): " + Arrays.toString(doubleArray));
        swap(doubleArray, 0, 3);
        System.out.println("After swap (Double): " + Arrays.toString(doubleArray));
    }
}
