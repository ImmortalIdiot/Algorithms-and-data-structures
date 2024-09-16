package com.immortalidiot;

public class Main {
    public static void main(String[] args) {
        DoubledLinkedList<String> doubledLinkedList = new DoubledLinkedList<>();
        doubledLinkedList.add("Один");
        doubledLinkedList.add("Два");
        doubledLinkedList.add(2, "Три");

        System.out.println("Size - " + doubledLinkedList.size());

        System.out.println("Все значения #1:");
        for (String value : doubledLinkedList) {
            System.out.println(value);
        }

        doubledLinkedList.setValue("Четыре", 2);
        System.out.println("Все значения #2:");
        for (String value : doubledLinkedList) {
            System.out.println(value);
        }

        System.out.println("2 элемент: " + doubledLinkedList.getElement(1));

        doubledLinkedList.remove((doubledLinkedList.size() - 1));
        System.out.println("Все значения #3:");
        for (String value : doubledLinkedList) {
            System.out.println(value);
        }

        while (doubledLinkedList.listIterator().hasNext()) {
            doubledLinkedList.remove(doubledLinkedList.listIterator().next());
        }

        System.out.println("Все значения #4:");
        if (!doubledLinkedList.isEmpty()) {
            for (String value : doubledLinkedList) {
                System.out.println(value);
            }
        } else {
            System.out.println("Значений нет");
        }
    }
}