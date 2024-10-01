package com.immortalidiot;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomStack<T> implements Iterable<T> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    private T[] stack;

    @SuppressWarnings(value = "unchecked")
    public CustomStack() {
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings(value = "unchecked")
    public CustomStack(int capacity) {
        stack = (T[]) new Object[capacity];
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public int capacity() { return stack.length; }

    public void clearAll() {
        for (int i = 0; i < size; i++) {
            stack[i] = null;
        }
        size = 0;
    }

    public void push(T data) {
        if (size == stack.length) {
            increaseCapacity(capacity() + 1);
        }
        stack[size++] = data;
    }

    public T pop() {
        checkIsEmpty();

        T data = stack[--size];
        stack[size] = null;

        return data;
    }

    public T peek() {
        checkIsEmpty();
        return stack[size - 1];
    }

    public void printStack() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    private void checkIsEmpty() {
        if (isEmpty()) { throw new NoSuchElementException("Стек пустой"); }
    }

    @SuppressWarnings("unchecked")
    private void increaseCapacity(int newCapacity) {
        T[] newStack = (T[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int index = size - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            return stack[index--];
        }
    }
}
