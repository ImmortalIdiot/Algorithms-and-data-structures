package com.immortalidiot;

import java.util.NoSuchElementException;

public class DoubledLinkedList<ObjectType> {

    public static class Node<ObjectType> {
        ObjectType data;
        Node<ObjectType> previous;
        Node<ObjectType> next;

        public Node(ObjectType data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public class Iterator {
        private Node<ObjectType> current;
        private int index;

        public Iterator() {
            this.current = head;
            this.index = 0;
        }

        public boolean hasNext() {
            return current != null;
        }

        public boolean hasPrevious() {
            return current != null && current.previous != null;
        }

        public ObjectType next() {
            if (!hasNext()) { throw new NoSuchElementException("No next element"); }
            ObjectType data = current.data;
            current = current.next;
            index++;
            return data;
        }

        public ObjectType previous() {
            if (!hasPrevious()) { throw new NoSuchElementException("No previous element"); }
            current = current.previous;
            index--;
            return current.data;
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

    public ObjectType getByIndex(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException("Index out of bounds"); }

        Node<ObjectType> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void replaceAt(ObjectType newValue, int index) {
        getNode(index).data = newValue;
    }

    public void removeByIndex(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException("Index out of bounds"); }

        Node<ObjectType> removableNode = getNode(index);

        if (removableNode == head) {
            head = removableNode.next;
            if (head != null) { head.previous = null; }
        } else if (removableNode == tail) {
            tail = removableNode.previous;
            if (tail != null) { tail.next = null; }
        } else {
            removableNode.previous.next = removableNode.next;
            removableNode.next.previous = removableNode.previous;
        }

        size--;

        if (size == 0) { head = null; tail = null; }
    }

    private Node<ObjectType> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<ObjectType> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
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
