/*
 * 3 - Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
Input:head = [1,1,2] 
Output:[1,2]

 */

import java.io.*;
import java.util.*;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);

        // LinkedList is empty?
        if (head == null) {
            head = new Node(newData);
            return;
        }

        // If LL is not empty
        newNode.next = null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void displayLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void deleteDuplicate() {
        if (head == null || head.next == null) {
            return;
        }
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return;
    }
}

public class LLQues3 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(2);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.displayLinkedList();
        System.out.println();
        ll.deleteDuplicate();
        ll.displayLinkedList();

    }
}
