/*
 * Q2. Insert a node at the given position in a linked list. We are given a pointer to a node, and the
new node is inserted after the given node.
Input : LL = 1 -> 2 -> 4 -> 5 -> 6	pointer = 2	    value =  3.
Output : 1 -> 2 -> 3 -> 4 -> 5 -> 6
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

    public void displayLinkedList(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void insertAtPosistion(int ptr, int newData){
        Node newNode = new Node(newData);
        if (ptr == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node prev = head;
        int currentPosition = 1;

        while (prev != null && currentPosition < ptr - 1) {
            prev = prev.next;
            currentPosition++;
        }
        if (prev == null) {
            System.out.println("Cannot insert");
            return;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }
}

public class LLQues2 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.insertAtEnd(6);
        ll.insertAtPosistion(2, 9);
        ll.displayLinkedList();
        
    }
}

