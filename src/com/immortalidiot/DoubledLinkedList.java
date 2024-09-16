package com.immortalidiot;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubledLinkedList<ObjectType> extends AbstractSequentialList<ObjectType> {

    private static class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        public Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
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

    @Override
    public int size() { return size; }

    @Override
    public ListIterator<ObjectType> listIterator(int index) {
        if (index < 0 || index > size) { throw new IndexOutOfBoundsException("Out of bounds: " + index); }

        return new ListIterator<>() {
            private Node<ObjectType> current = (index == size) ? null : getNode(index);
            private Node<ObjectType> last = null;
            private int cursor = index;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public ObjectType next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                last = current;
                ObjectType data = current.data;
                current = current.next;
                cursor++;
                return data;
            }

            @Override
            public boolean hasPrevious() {
                return cursor > 0;
            }

            @Override
            public ObjectType previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                current = (current == null) ? tail : current.previous;
                last = current;
                cursor--;
                return current.data;
            }

            @Override
            public int nextIndex() {
                return cursor;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {
                if (last == null) { throw new NoSuchElementException(); }
                DoubledLinkedList.this.remove(last.data);
                last = null;
            }

            @Override
            public void set(ObjectType objectType) {
                if (last == null) {
                    throw new IllegalStateException();
                }
                last.data = objectType;
            }

            @Override
            public void add(ObjectType objectType) {
                if (cursor == size) {
                    DoubledLinkedList.this.add(objectType);
                } else {
                    Node<ObjectType> newNode = new Node<>(objectType, current.previous, current);
                    if (current.previous != null) {
                        current.previous.next = newNode;
                    }
                    if (current != null) {
                        current.previous = newNode;
                    }
                    if (current == head) {
                        head = newNode;
                    }
                    size++;
                }
                cursor++;
                last = null;
            }
        };
    }

    @Override
    public boolean add(ObjectType objectType) {
        Node<ObjectType> newNode = new Node<>(objectType, tail, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    public void add(int index, ObjectType objectType) {
        if (index < 0 || index > size) { throw new IndexOutOfBoundsException("Out of bounds: " + index); }
        if (index == size) {
            add(objectType);
        } else {
            Node<ObjectType> successor = getNode(index);
            Node<ObjectType> predecessor = successor.previous;
            Node<ObjectType> newNode = new Node<>(objectType, predecessor, successor);
            if (predecessor != null) {
                predecessor.next = newNode;
            } else {
                head = newNode;
            }
            successor.previous = newNode;
            size++;
        }
    }

    @Override
    public boolean remove(Object object) {
        for (Node<ObjectType> node = head; node != null; node = node.next) {
            if (object.equals(node.data)) {
                removeLink(node);
                return true;
            }
        }
        return false;
    }

    public ObjectType getElement(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException("Out of bounds: " + index); }
        return getNode(index).data;
    }

    public void setValue(ObjectType value, int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException("Out of bounds: " + index); }

        Node<ObjectType> node = getNode(index);
        node.data = value;
    }

    public ObjectType remove(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException("Out of bounds: " + index); }
        Node<ObjectType> node = getNode(index);
        ObjectType oldValue = node.data;
        removeLink(node);
        return oldValue;
    }

    private void removeLink(Node<ObjectType> node) {
        Node<ObjectType> previous = node.previous;
        Node<ObjectType> next = node.next;

        if (previous == null) {
            head = next;
        } else {
            previous.next = next;
            node.previous = null;
        }

        if (next == null) {
            tail = previous;
        } else {
            next.previous = previous;
            node.next = null;
        }

        node.data = null;
        size--;
    }

    private Node<ObjectType> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Out of bounds: " + index);
        }

        Node<ObjectType> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void printAll() {
        for (ObjectType objectType : this) {
            System.out.println(objectType);
        }
    }
}
