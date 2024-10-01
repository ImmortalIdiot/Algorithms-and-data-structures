package com.immortalidiot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static final Minion FIRST = new Minion("Bob", 2, 5, 2);
    static final Minion SECOND = new Minion("Stuart", 14, 25, 2);
    static final Minion THIRD = new Minion("Kevin", 1, 17, 1);
    static final Minion FOURTH = new Minion("Rayan", 6, 22, 4);
    static final Minion FIFTH = new Minion("Fixer", 8, 9, 2);

    public static void main(String[] args) {
//        testStack();
//        testIterator();
//        testComparator();
        comparatorTask();
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

        System.out.println("\nУдалён " + minionStack.pop());
        System.out.println("Удалён " + minionStack.pop() + "\n");

        System.out.println("Демонстрация итератора:");
        for (Minion minion : minionStack) {
            System.out.println(minion);
        }
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
        list.replaceAt(new Minion("Реинкарнат", 3, 8, 2), replaceableIndex);
        System.out.println("Новый миньон: " + list.getByIndex(replaceableIndex) + "\n");

        int removableIndex = 1;
        System.out.println("Удаляем " + list.getByIndex(removableIndex) + "\n");
        list.removeByIndex(removableIndex);
        System.out.println("Итоговый список:");
        list.printList();
    }

    public static void testComparator() {
        List<Minion> minions = new ArrayList<>();

        Minion firstAdditional = new Minion("Gachi", 1, 50, 2);
        Minion secondAdditional = new Minion("Gleb", 2, 20, 2);
        Minion thirdAdditional = new Minion("Fishka", 8, 11, 2);

        minions.add(0, FIFTH);
        minions.add(0, SECOND);
        minions.add(1, THIRD);
        minions.add(3, FIRST);
        minions.add(2, FOURTH);
        minions.add(1, firstAdditional);
        minions.add(0, secondAdditional);
        minions.add(3, thirdAdditional);

        System.out.println("Полученный список:");
        for (Minion minion : minions) {
            System.out.println(minion);
        }

        System.out.println("\nОтсортированный список:");
        minions.sort(Minion::compareTo);
        for (Minion minion : minions) {
            System.out.println(minion);
        }
    }

    public static boolean isBalanced(String s) {
        CustomStack<Character> stack = new CustomStack<>();

        for (char character : s.toCharArray()) {
            if (character == '(' || character == '[') {
                stack.push(character);
            } else if(character == ')' || character == ']') {
                if (stack.isEmpty()) { return false; }

                char lastCharacter = stack.pop();
                if (!isMatchingPair(lastCharacter, character)) { return false; }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opened, char closed) {
        return (opened == '(' && closed == ')') || (opened == '[' && closed == ']');
    }

    private static void stackTask() {
        String expression = "[()]";
        if (isBalanced(expression)) {
            System.out.println("Скобки расставлены верно");
        } else {
            System.out.println("Скобки расставлены неверно");
        }
    }

    private static void comparatorTask() {
        // имя - обратный алфавитный, количество символов в имени - возраст (убывание), сумма рук и глаз (возрастание)
        Minion[] minions = {
            new Minion("Alex", 2, 5, 2),
            new Minion("Alex", 1, 7, 2),
            new Minion("Carl", 2, 8, 2),
            new Minion("Dave", 2, 8, 2),
            new Minion("Dave", 1, 8, 2),
            new Minion("Zeus", 2, 5, 2),
            new Minion("Zeus", 1, 4, 3)
        };

        Arrays.sort(minions);

        for (Minion minion : minions) {
            System.out.println(minion);
        }
    }
}
