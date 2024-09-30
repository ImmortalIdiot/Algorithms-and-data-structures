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

    @SuppressWarnings("ClassEscapesDefinedScope")
    public ObjectType next(Node<ObjectType> current) {
        if (current == null || current.next == null) {
            throw new NoSuchElementException("No next element");
        }
        return current.next.data;
    }

    @SuppressWarnings("ClassEscapesDefinedScope")
    public ObjectType previous(Node<ObjectType> current) {
        if (current == null || current.previous == null) {
            throw new NoSuchElementException("No previous element");
        }
        return current.previous.data;
    }

    public ObjectType getByIndex(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException("Index out of bounds"); }

        Node<ObjectType> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
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

    public void printList() {
        Node<ObjectType> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
