import java.util.*;
import java.io.*;

public class LinkedList {
    Node head;
    
    class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    //display method implementation
    public void displayLinkedList(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    //Implementation of insertion of a node at the end
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

    //Implementation of insertion of a node at the beginning
    public void insertAtStart(int newData){
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    //Implementation of insertion of a node at any position
    public void insertToPosition(Node prev, int newData){
        if(prev == null){
            System.out.println("The previos node cannot contain null values");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prev.next;
        prev.next = newNode;
    }

    //Deletion in Linked List
    public void deleteNode(int position){
        //LL is empty
        if(head == null) return;

        Node temp = head;

        //deletion is in the beginning of the node
        if(position == 0){
            head = temp.next;
            return;
        }

        //deletion is not in the beginning of the node
        for (int i = 0; temp != null && i < position-1; i++) {
            temp = temp.next;
        }

        if(temp == null && temp.next == null){
            return;
        }

        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtEnd(2);
        list.insertAtEnd(4);
        list.insertAtEnd(8);

        list.displayLinkedList();
        System.out.println();

        list.insertAtStart(10);

        list.displayLinkedList();
        System.out.println();

        list.insertToPosition(list.head.next, 12);

        list.displayLinkedList();
        System.out.println();

        list.deleteNode(2);

        list.displayLinkedList();

    }
}
