package com.immortalidiot;

public class Main {
    public static void main(String[] args) {
        checkWithMinionType();
    }

    private static void checkWithMinionType() {
        DoubledLinkedList<Minion> minions = new DoubledLinkedList<>();
        minions.printAll();

        Minion minion = new Minion("Cферик", 2);
        Minion otherMinion = new Minion("Глеб", 4);

        minions.add(new Minion("Фиксик", 15));
        System.out.println("Добавлен миньон " + minions.getLast());
        minions.add(minion);
        System.out.println("Добавлен миньон " + minions.getLast());
        minions.add(new Minion("Псиныч", 11));
        System.out.println("Добавлен миньон " + minions.getLast());

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
        doubledLinkedList.printAll();


        doubledLinkedList.add("Один");
        System.out.println("Добавлен элемент " + doubledLinkedList.getLast());
        doubledLinkedList.add("Два");
        System.out.println("Добавлен элемент " + doubledLinkedList.getLast());
        doubledLinkedList.add(2, "Три");
        System.out.println("Добавлен элемент по индексу 2" + doubledLinkedList.getElement(2));

        System.out.println("Размер - " + doubledLinkedList.size());

        doubledLinkedList.printAll();

        doubledLinkedList.setValue("Четыре", 2);
        doubledLinkedList.printAll();

        System.out.println("1 элемент: " + doubledLinkedList.getElement(1));

        doubledLinkedList.remove((doubledLinkedList.size() - 1));
        doubledLinkedList.printAll();

        while (doubledLinkedList.listIterator().hasNext()) {
            doubledLinkedList.remove(doubledLinkedList.listIterator().next());
        }

        doubledLinkedList.printAll();
    }
}