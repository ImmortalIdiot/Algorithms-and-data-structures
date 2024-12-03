package com.immortalidiot.queue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        AbstractQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(5);
        priorityQueue.add(30);

        System.out.println("Size: " + priorityQueue.size());
        System.out.println("Peek: " + priorityQueue.peek());
        System.out.println("First poll: " + priorityQueue.poll());
        System.out.println("Second poll: " + priorityQueue.poll());
        System.out.println("Third poll: " + priorityQueue.poll());
        System.out.println("Fourth poll: " + priorityQueue.poll());
        System.out.println("Peek: " + priorityQueue.peek());
        System.out.println("Size: " + priorityQueue.size());
    }
}
