package com.learn.algorithms.linklist;

public class LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    void addData(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node ptr = head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = new Node(data);
        }
    }

    void addDataToHead(int data) {
        Node ptr = new Node(data);
        ptr.next = head;
        head = ptr;
    }

    void addDataAfter(int data) {
        
    }

    void deleteHead() {

    }

    void deleteTail() {

    }

    void delete(int data) {

    }

    void print() {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data);
            System.out.print(" ");
            ptr = ptr.next;
        }
        System.out.println();

    }

    int size() {
        int size = 0;
        Node pointer = head;
        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }

        return size;
    }
}
