package com.immortalidiot.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class AbstractQueueImpl<T extends Comparable<T>> implements AbstractQueue<T> {

    private T[] queue;
    private int size;

    public AbstractQueueImpl() {
        this.queue = null;
        this.size = 0;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(T element) {
        if (queue.length == size) {
            queue = resize();
        }
        queue[size++] = element;
        reorder();
    }

    @Override
    public T peek() {
        if (size == 0) { return null; }
        return queue[0];
    }

    @Override
    public T poll() {
        if (size == 0) { return null; }
        T maxElement = queue[0];

        System.arraycopy(queue, 1, queue, 0, size - 1);

        queue[--size] = null;
        return maxElement;
    }

    private T[] resize() {
        return Arrays.copyOf(queue, queue.length * 2);
    }

    private void reorder() {
        Arrays.sort(queue, 0, size, Comparator.reverseOrder());
    }
}
