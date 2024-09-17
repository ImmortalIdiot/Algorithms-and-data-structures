package com.immortalidiot;

public class Main {
    public static void main(String[] args) {
        Minion minion1 = new Minion("Bob", 25);
        Minion minion2 = new Minion("Kevin", 14);
        Minion minion3 = new Minion("Stuart", 7);
        Minion minion4 = new Minion("Gleb", 3);
        Minion minion5 = new Minion("Fixer", 1);

        DoubledLinkedList<Minion> list = new DoubledLinkedList<>();

        list.insertHead(minion1);
        list.insertTail(minion2);
        list.insertHead(minion3);
        list.insertTail(minion4);
        list.insertTail(minion5);

        System.out.println("Размер списка: " + list.size());

        System.out.println("Первый элемент (next): " + list.next());
        System.out.println("Ожидалось: " + minion3);

        System.out.println("Последний элемент (previous): " + list.previous());
        System.out.println("Ожидалось: " + minion5);

        System.out.println("Первый элемент: " + list.getFirst());

        System.out.println("Последний элемент: " + list.getLast());

        list.replaceFirst(new Minion("Тим", 2));
        System.out.println("Новый первый элемент " + list.getFirst());

        list.replaceLast(new Minion("Мел", 1)); // Заменяем m5 на Мел
        System.out.println("Последний элемент после замены: " + list.getLast());

        System.out.println("Последний элемент после замены (previous): " + list.previous());

        list.replace(new Minion("Грю", 1), new Minion("Эд", 2)); // Заменяем Грю на Эд

        list.removeFirst();
        System.out.println("Первый элемент после удаления первого: " + list.getFirst());

        list.removeLast();
        System.out.println("Последний элемент после удаления последнего: " + list.getLast());

        System.out.println("Размер списка после удалений: " + list.size());
    }
}
