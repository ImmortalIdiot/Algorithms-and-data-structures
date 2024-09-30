package com.immortalidiot;


public class Minion {

    private final String minionName;
    private final int eyesCount;
    private final int age;

    public Minion(String minionName, int eyesCount, int age) {
        this.minionName = minionName;
        this.eyesCount = eyesCount;
        this.age = age;
    }

    @Override
    public String toString() {
        String eyeWord = (eyesCount == 1) ? "глазом" : "глазами";

        String yearWord;
        if (age % 10 == 1 && age % 100 != 11) {
            yearWord = "год";
        } else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
            yearWord = "года";
        } else {
            yearWord = "лет";
        }

        return "Миньон " + minionName + " с " + eyesCount + " " + eyeWord + " и возрастом " + age + " " + yearWord + ".";
    }

    public int compareTo(Minion otherMinion) {
        int eyesComparing = Integer.compare(this.eyesCount, otherMinion.eyesCount);
        if (eyesComparing != 0) { return eyesComparing; }

        int ageComparing = Integer.compare(this.age, otherMinion.age);
        if (ageComparing != 0) { return ageComparing; }

        return this.minionName.compareTo(otherMinion.minionName);
    }
}
