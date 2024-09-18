package com.immortalidiot;

public class Main {
    public static void main(String[] args) {
        Minion minion1 = new Minion("Bob", 25);
        Minion minion2 = new Minion("Kevin", 14);
        Minion minion3 = new Minion("Stuart", 7);
        Minion minion4 = new Minion("Rayan", 3);
        Minion minion5 = new Minion("Fixer", 1);

        DoubledLinkedList<Minion> list = new DoubledLinkedList<>();

        list.insertHead(minion1);
        list.insertTail(minion2);
        list.insertHead(minion3);
        list.insertTail(minion4);
        list.insertTail(minion5);

        System.out.println("Весь список");
        list.printList();
        System.out.println();

        System.out.println("Размер");
        System.out.println(list.size());
        System.out.println();t

        System.out.println("Заменяем первый");
        list.replaceFirst(new Minion("Максим", 2));
        list.printList();
        System.out.println();

        System.out.println("Заменяем последний");
        list.replaceLast(new Minion("Никита", 1));
        list.printList();
        System.out.println();

        System.out.println("Заменяем Bob");
        list.replace(minion1, new Minion("Глеб", 25));
        list.printList();
        System.out.println();

        System.out.println("Удаляем первый");
        list.removeFirst();
        list.printList();
        System.out.println();

        System.out.println("Удаляем последний");
        list.removeLast();
        list.printList();
        System.out.println();

        System.out.println();
        System.out.println("Размер после удаления\n" + list.size());
    }
}
