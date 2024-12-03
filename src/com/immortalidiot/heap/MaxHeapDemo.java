package com.immortalidiot.heap;

public class MaxHeapDemo {

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);
        maxHeap.add(30);

        System.out.println("Peek: " + maxHeap.peek());
        System.out.println("Size: " + maxHeap.size());
        maxHeap.printAll();
    }
}
