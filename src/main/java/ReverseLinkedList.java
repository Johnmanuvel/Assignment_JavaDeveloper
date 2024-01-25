package main.java;

import java.util.*;
public class ReverseLinkedList {
    static class Node {
        int data;
        Node next = null;
        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        first.next = second;
        second.next = third;
        printList(first);
        Node reversed = reverseList(first);
        System.out.println("\nReversed Linked List:");
        printList(reversed);
    }

    public static Node reverseList(Node head) {
        Node curr = head;
        Stack<Node> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        Node res = new Node(-1);
        curr = res;
        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return res.next;
    }
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
