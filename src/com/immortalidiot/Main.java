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
        System.out.println("Ожидалось: 5");

        System.out.println("Первый элемент (next): " + list.next());
        System.out.println("Ожидалось: " + minion3);

        System.out.println("Последний элемент (previous): " + list.previous());
        System.out.println("Ожидалось: " + minion5);

        System.out.println("Элемент по индексу 0: " + list.getElement(0));
        System.out.println("Ожидалось: " + minion3);

        System.out.println("Элемент по индексу 4: " + list.getElement(4));
        System.out.println("Ожидалось: " + minion5);

        list.setValue(new Minion("Тим", 2), 0); // Заменяем m3 на Тим
        System.out.println("После замены элемента по индексу 0: " + list.getElement(0));
        System.out.println("Ожидалось: " + new Minion("Тим", 2));

        // Проверяем replaceFirst и replaceLast
        list.replaceFirst(new Minion("Грю", 1)); // Заменяем m1 на Грю
        list.replaceLast(new Minion("Мел", 1)); // Заменяем m5 на Мел
        System.out.println("Первый элемент после замены (next): " + list.next());
        System.out.println("Ожидалось: " + new Minion("Грю", 1));

        System.out.println("Последний элемент после замены (previous): " + list.previous());
        System.out.println("Ожидалось: " + new Minion("Мел", 1));

        list.replace(new Minion("Грю", 1), new Minion("Эд", 2)); // Заменяем Грю на Эд
        System.out.println("Элемент по индексу 1 после замены: " + list.getElement(1));
        System.out.println("Ожидалось: " + new Minion("Эд", 2));

        list.removeFirst();
        System.out.println("Элемент по индексу 0 после удаления первого: " + list.getElement(0));
        System.out.println("Ожидалось: " + new Minion("Эд", 2));

        list.removeLast();
        System.out.println("Элемент по индексу 2 после удаления последнего: " + list.getElement(2));
        System.out.println("Ожидалось: " + new Minion("Эд", 2));

        System.out.println("Размер списка после удалений: " + list.size());
        System.out.println("Ожидалось: 3");
    }
}
