/*
 * \4 - Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false

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

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        int middle = length / 2;
        Node firstHalf = null;
        current = head;
        for (int i = 0; i < middle; i++) {
            Node nextNode = current.next;
            current.next = firstHalf;
            firstHalf = current;
            current = nextNode;
        }
        if (length % 2 == 1) {
            current = current.next;
        }
        while (current != null) {
            if (firstHalf.value != current.value) {
                return false;
            }
            firstHalf = firstHalf.next;
            current = current.next;
        }
        return true;
    }
}

public class LLQues4 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(2);
        ll.insertAtEnd(1);
        System.out.println(ll.isPalindrome());
    }  
}
