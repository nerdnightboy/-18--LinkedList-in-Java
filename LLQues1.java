/*
 * 1 - Given a linked list and a key ‘X‘ in, the task is to check if X is present in the linked list or not.
Input 1: 14->21->11->30->10, X = 14
Output 1: Yes
Explanation: 14 is present in the linked list
Input 1: 6->21->17->30->10->8, X = 13
Output 1: No

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

    public void insertAtEnd(int newData){
        Node newNode = new Node(newData);

        //LinkedList is empty?
        if(head == null){
            head = new Node(newData);
            return;
        }

        //If LL is not empty
        newNode.next = null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    boolean contains(int key) {
        Node current = head;
        while (current != null) {
            if (current.value == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

public class LLQues1 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(14);
        ll.insertAtEnd(21);
        ll.insertAtEnd(11);
        ll.insertAtEnd(30);
        ll.insertAtEnd(10);

        int key = 14;
        if (ll.contains(key)) {
            System.out.println("Yes, X is present");
        } else {
            System.out.println("No, X is not present");
        }
    }
}
