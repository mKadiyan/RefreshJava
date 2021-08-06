package com.learn.algorithms.linklist;

public class TestLinkList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addData(10);
        linkedList.addData(2);
        linkedList.addData(5);
        linkedList.addData(9);
        System.out.println(linkedList.size());
        linkedList.print();

        linkedList.addDataToHead(21);
        System.out.println(linkedList.size());
        linkedList.print();
    }
}
