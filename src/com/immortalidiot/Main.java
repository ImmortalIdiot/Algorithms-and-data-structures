package com.immortalidiot;

public class Main {
    public static void main(String[] args) {
        checkWithMinionType();
    }

    private static void checkWithMinionType() {
        DoubledLinkedList<Minion> minions = new DoubledLinkedList<>();

        Minion minion = new Minion("Cферик", 2);
        Minion otherMinion = new Minion("Глеб", 4);

        minions.add(new Minion("Фиксик", 15));
        minions.add(minion);
        minions.add(new Minion("Псиныч", 11));

        minions.printAll();
        System.out.println("Изменяем " + minions.getElement(1) + " на " + otherMinion);
        minions.setValue(otherMinion, 1);
        minions.printAll();

        System.out.println("Удаляем " + otherMinion);
        minions.remove(otherMinion);
        minions.printAll();
    }

    private static void checkWithStringType() {
        DoubledLinkedList<String> doubledLinkedList = new DoubledLinkedList<>();
        doubledLinkedList.add("Один");
        doubledLinkedList.add("Два");
        doubledLinkedList.add(2, "Три");

        System.out.println("Size - " + doubledLinkedList.size());

        doubledLinkedList.printAll();

        doubledLinkedList.setValue("Четыре", 2);
        doubledLinkedList.printAll();

        System.out.println("2 элемент: " + doubledLinkedList.getElement(1));

        doubledLinkedList.remove((doubledLinkedList.size() - 1));
        doubledLinkedList.printAll();

        while (doubledLinkedList.listIterator().hasNext()) {
            doubledLinkedList.remove(doubledLinkedList.listIterator().next());
        }

        if (!doubledLinkedList.isEmpty()) {
            doubledLinkedList.printAll();
        } else {
            System.out.println("Значений нет");
        }
    }
}