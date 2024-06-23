
//Day-12 Task 8: 
//Circular Queue Binary Search
//Consider a circular queue (implemented using a fixed-size array) where the elements
//are sorted but have been rotated at an unknown index. Describe an approach to 
//perform a binary search for a given element within this circular queue.

//Solution:

package com.day12.task8;
public class CircularBinarySearch {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        // Find the pivot point
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int pivot = left;

        // Choose the search space based on the target element and pivot
        left = 0;
        right = n - 1;
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot;
        }

        // Perform binary search within the chosen search space
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = search(nums, target);
        System.out.println("Element " + target + " found at index " + index);
    }
}
