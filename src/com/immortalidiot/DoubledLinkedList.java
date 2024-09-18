package com.immortalidiot;

import java.util.NoSuchElementException;

public class DoubledLinkedList<ObjectType> {

    private static class Node<ObjectType> {
        ObjectType data;
        Node<ObjectType> previous;
        Node<ObjectType> next;

        public Node(ObjectType data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    private Node<ObjectType> head;
    private Node<ObjectType> tail;
    private int size;

    public DoubledLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() { return size; }

    public ObjectType next() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public ObjectType previous() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    public void insertHead(ObjectType objectType) {
        Node<ObjectType> newNode = new Node<>(objectType);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertTail(ObjectType objectType) {
        Node<ObjectType> newNode = new Node<>(objectType);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (head == null) { return; }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
    }

    public void removeLast() {
        if (tail == null) { return; }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
    }

    public void replaceFirst(ObjectType objectType) {
        if (head != null) {
            head.data = objectType;
        }
    }

    public void replaceLast(ObjectType objectType) {
        if (tail != null) {
            tail.data = objectType;
        }
    }

    public void replace(ObjectType oldValue, ObjectType newValue) {
        Node<ObjectType> current = head;
        while (current != null) {
            if (current.data.equals(oldValue)) {
                current.data = newValue;
                return;
            }
            current = current.next;
        }
    }

    public ObjectType getFirst() {
        return head.data;
    }

    public ObjectType getLast() {
        return tail.data;
    }
}
