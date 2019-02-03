package com.cuizhiwen.jdk.collection.map;

public class Node {
    private Node next;
    private Object item;

    public Node(Node next, Object item) {
        this.next = next;
        this.item = item;
    }

    public static void main(String[] args) {
        Node header = new Node(null,new Object());
        header = new Node(header,new Object());

    }
}
