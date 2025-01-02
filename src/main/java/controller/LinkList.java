package controller;

import java.util.Locale;

public class LinkList<T> {



    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkList() {
        this.head = null;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean remove(T data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        return true;
    }

    public T find(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
}
