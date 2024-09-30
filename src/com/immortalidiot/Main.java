package com.immortalidiot;

public class Main {

    static final Minion FIRST = new Minion("Bob", 2, 5);
    static final Minion SECOND = new Minion("Stuart", 14, 25);
    static final Minion THIRD = new Minion("Kevin", 1, 17);
    static final Minion FOURTH = new Minion("Rayan", 6, 22);
    static final Minion FIFTH = new Minion("Fixer", 8, 9);

    public static void main(String[] args) {
        testStack();
    }

    public static void testStack() {
        CustomStack<Minion> minionStack = new CustomStack<>();

        minionStack.push(FIRST);
        minionStack.push(SECOND);
        minionStack.push(THIRD);
        minionStack.push(FOURTH);
        minionStack.push(FIFTH);

        System.out.println("Список миньонов:");
        minionStack.printStack();

        System.out.println("\nВерхний элемент: " + minionStack.peek());

        System.out.println("Итоговый список:");
        System.out.println("\nУдалён " + minionStack.pop());
        System.out.println("Удалён " + minionStack.pop() + "\n");

        minionStack.printStack();
    }

    public static void testIterator() {
        DoubledLinkedList<Minion> list = new DoubledLinkedList<>();

        list.insertByIndex(list.size(), FIRST);
        list.insertByIndex(list.size() - 1, SECOND);
        list.insertByIndex(0, THIRD);
        list.insertByIndex(2, FOURTH);
        list.insertByIndex(list.size(), FIFTH);

        System.out.println("Список миньонов:");
        list.printList();
        System.out.println();

        DoubledLinkedList<Minion>.Iterator iterator = list.new Iterator();

        System.out.println("Демонстрация методов итератора hasNext(): и next()");
        while (iterator.hasNext()) {
            System.out.println("Указатель на миньона: " + iterator.next());
        }
        System.out.println();

        int gettingIndex = 2;
        System.out.println("Миньон по индексу " + gettingIndex + ":");
        System.out.println(list.getByIndex(gettingIndex) + "\n");

        int replaceableIndex = 2;
        System.out.println("Заменяем " + list.getByIndex(replaceableIndex) + ":");
        list.replaceAt(new Minion("Реинкарнат", 3, 8), replaceableIndex);
        System.out.println("Новый миньон: " + list.getByIndex(replaceableIndex) + "\n");

        int removableIndex = 1;
        System.out.println("Удаляем " + list.getByIndex(removableIndex) + "\n");
        list.removeByIndex(removableIndex);
        System.out.println("Итоговый список:");
        list.printList();
    }
}
