//Day-12 Task7
//Merging Two Sorted Linked Lists
//You are provided with the heads of two sorted linked lists. 
//The lists are sorted in ascending order. 
//Create a merged linked list in ascending order from the two input lists without 
//using any extra space (i.e., do not create any new nodes).

//Solution
//Algorithm:
//1) Compare the values of the head nodes of the two lists.
//2) Attach the smaller node as the head of the merged list.
//3) Move the pointer of the merged list to the smaller node.
//4) Move the pointer of the list from which the smaller node was taken.
//5) Repeat steps 1-4 until one of the lists becomes empty.
//6) Attach the remaining nodes of the non-empty list to the merged list.


//Implementation:
package com.day12.task7;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeLinkedLists {

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
        // Dummy node to hold the merged list
        ListNode dummy = new ListNode(-1);
        ListNode merged = dummy;

        // Merge until one of the lists becomes empty
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                merged.next = l1;
                l1 = l1.next;
            } else {
                merged.next = l2;
                l2 = l2.next;
            }
            merged = merged.next;
        }

        // Attach the remaining nodes of the non-empty list
        merged.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage:
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("List 1:");
        printList(l1);
        System.out.println("List 2:");
        printList(l2);

        ListNode merged = mergeLists(l1, l2);

        System.out.println("Merged list:");
        printList(merged);
    }
}
