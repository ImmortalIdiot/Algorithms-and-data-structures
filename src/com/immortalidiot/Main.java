package com.immortalidiot;

public class Main {
    public static void main(String[] args) {
        testStack();
    }

    public static void testStack() {
        CustomStack<Minion> minionStack = new CustomStack<>();

        minionStack.push(new Minion("Bob", 2, 5));
        minionStack.push(new Minion("Kevin", 1, 8));
        minionStack.push(new Minion("Stuart", 2, 3));
        minionStack.push(new Minion("Rayan", 3, 7));
        minionStack.push(new Minion("Fixer", 2, 5));

        minionStack.printStack();

        System.out.println("\nВерхний элемент: " + minionStack.peek());

        System.out.println("\nУдалён " + minionStack.pop());
        System.out.println("Удалён " + minionStack.pop() + "\n");

        minionStack.printStack();
    }
}
