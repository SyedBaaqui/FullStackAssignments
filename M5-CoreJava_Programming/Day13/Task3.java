/*Day-13 Task 3: 
Implementing Heap Operations
Code a min-heap in java with methods for insertion, deletion, and 
fetching the minimum element. Ensure that the heap property is maintained 
after each operation."
*/

//Solution:
package day13.task3;
import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }

        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] < heap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot delete.");
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int index) {
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is empty. No minimum element.");
            return -1;
        }

        return heap[0];
    }

    public void printHeap() {
        System.out.print("Heap: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(4);

        minHeap.printHeap(); // Output: Heap: 1 2 3 5 4

        System.out.println("Minimum element: " + minHeap.getMin()); // Output: Minimum element: 1

        minHeap.deleteMin();
        minHeap.printHeap(); // Output: Heap: 2 4 3 5

        System.out.println("Minimum element: " + minHeap.getMin()); // Output: Minimum element: 2
    }
}


