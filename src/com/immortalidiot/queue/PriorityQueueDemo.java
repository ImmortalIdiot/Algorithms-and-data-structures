package com.immortalidiot.queue;

import java.util.Random;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("Создадим очередь с размером 10_000 на массиве");
        AbstractQueueImpl<Integer> arrayPriorityQueue = new AbstractQueueImpl<>(10_000);

        Random random = new Random();
        int n = 10_000;
        int[] randomArray = new int[n];

        for (int i = 0; i < n; i++) {
            randomArray[i] = random.nextInt(-1000, 1000);
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Добавим элементы в очередь на массиве");
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            arrayPriorityQueue.add(randomArray[i]);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения add на массиве: " + (endTime - startTime) + " мс");

        System.out.println("-------------------------------------------------");
        System.out.println("Получим максимальный элемент из очереди на массиве без удаления");
        startTime = System.currentTimeMillis();
        System.out.println("Максимальный элемент: " + arrayPriorityQueue.peek());
        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения peek на массиве: " + (endTime - startTime) + " мс");

        System.out.println("-------------------------------------------------");
        System.out.println("Удалим элементы из очереди на массиве");
        startTime = System.currentTimeMillis();

        while (arrayPriorityQueue.size() > 0) {
            arrayPriorityQueue.poll();
        }

        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения poll на массиве: " + (endTime - startTime) + " мс");

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("\n-------------------------------------------------");
        System.out.println("Создадим очередь на дереве");
        PriorityQueue<Integer> treePriorityQueue = new PriorityQueue<>();

        System.out.println("-------------------------------------------------");
        System.out.println("Добавим элементы в очередь на дереве");
        startTime = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            treePriorityQueue.add(randomArray[i]);
        }

        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения add на дереве: " + (endTime - startTime) + " мс");

        System.out.println("-------------------------------------------------");
        System.out.println("Получим максимальный элемент из очереди на дереве без удаления");
        startTime = System.currentTimeMillis();
        System.out.println("Максимальный элемент: " + treePriorityQueue.peek());
        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения peek на дереве: " + (endTime - startTime) + " мс");

        System.out.println("-------------------------------------------------");
        System.out.println("Удалим элементы из очереди на дереве");
        startTime = System.currentTimeMillis();

        while (treePriorityQueue.size() > 0) {
            treePriorityQueue.poll();
        }

        endTime = System.currentTimeMillis();
        System.out.println("Время выполнения poll на дереве: " + (endTime - startTime) + " мс");
    }
}
