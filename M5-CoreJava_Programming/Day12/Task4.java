//Day12-Task 4: 
//Stack Sorting In-Place
//You must write a function to sort a stack such that the smallest
//items are on the top. You can use an additional temporary stack, but you may 
//not copy the elements into any other data structure such as an array. The stack 
//supports the following operations: push, pop, peek, and isEmpty.

package com.day12.task4;
import java.util.Stack;

public class StackSort {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            // Move elements from tempStack to stack which are greater than temp
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }

            // Push temp into tempStack
            tempStack.push(temp);
        }

        // Copy elements from tempStack back to stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(3);
        stack.push(1);

        sortStack(stack);

        // Print sorted stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println(); // Output: 1 2 3 5 8
    }
}
