package com.immortalidiot.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class AbstractQueueImpl<T extends Comparable<T>> implements AbstractQueue<T> {
    private T[] queue;
    private int size = 0;
    private int capacity;

    @SuppressWarnings("unchecked")
    public AbstractQueueImpl(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("Размер очереди должен быть больше, либо равен 1");
        this.queue = (T[]) new Comparable[capacity];
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T element) {
        if (queue.length == size) {
            queue = resize();
        }
        queue[size++] = element;
        reorder();
    }

    @Override
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[0];
    }

    @Override
    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        T maxElement = queue[0];
        System.arraycopy(queue, 1, queue, 0, size - 1);
        queue[--size] = null;
        return maxElement;
    }

    private T[] resize() {
        this.capacity = capacity * 2;
        return Arrays.copyOf(queue, queue.length * 2);
    }

    private void reorder() {
        Arrays.sort(queue, 0, size, Comparator.reverseOrder());
    }

    public int getCapacity() {
        return capacity;
    }
}
