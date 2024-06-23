
//DAY-12 Task 6: 
//Searching for a Sequence in a Stack
//Given a stack and a smaller array representing a sequence, 
//write a function that determines if the sequence is present in the stack. 
//Consider the sequence present if, upon popping the elements, 
//all elements of the array appear consecutively in the stack.


package com.day12.task6;
import java.util.Stack;

public class SequenceInStack {

    public static boolean isSequencePresent(Stack<Integer> stack, int[] sequence) {
        int sequenceIndex = 0;

        // Iterate through the stack
        while (!stack.isEmpty()) {
            int current = stack.pop();

            // If the current element matches the next element in the sequence
            if (current == sequence[sequenceIndex]) {
                sequenceIndex++;

                // If all elements of the sequence have been found, return true
                if (sequenceIndex == sequence.length) {
                    return true;
                }
            }
        }

        // If the stack is empty but not all elements of the sequence have been found, return false
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        stack.push(1);

        int[] sequence1 = {3, 2, 4};
        int[] sequence2 = {1, 2, 3};

        System.out.println("Sequence 1 present in stack: " + isSequencePresent(stack, sequence1)); // Output: true
        System.out.println("Sequence 2 present in stack: " + isSequencePresent(stack, sequence2)); // Output: false
    }
}
