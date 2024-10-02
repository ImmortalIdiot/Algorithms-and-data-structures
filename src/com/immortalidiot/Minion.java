package com.immortalidiot;

public class Minion implements Comparable<Minion> {

    private final String minionName;
    private final int eyesCount;
    private final int age;
    private final int handCount;

    public Minion(String minionName, int eyesCount, int age, int handCount) {
        this.minionName = minionName;
        this.eyesCount = eyesCount;
        this.age = age;
        this.handCount = handCount;
    }

    @Override
    public String toString() {
        String eyeWord = (eyesCount == 1) ? " глазом " : " глазами ";

        String yearWord;
        if (age % 10 == 1 && age % 100 != 11) { yearWord = " год"; }
        else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) { yearWord = " года"; }
        else { yearWord = " лет"; }

        //return "Миньон " + minionName + " с " + eyesCount + eyeWord + "и возрастом " + age + yearWord;
        return minionName + ", " + eyesCount + ", " + age + ", " + handCount;
    }

    public int oldCompareTo(Minion otherMinion) {
        int eyesComparing = Integer.compare(this.eyesCount, otherMinion.eyesCount);
        if (eyesComparing != 0) { return eyesComparing; }

        int ageComparing = Integer.compare(this.age, otherMinion.age);
        if (ageComparing != 0) { return ageComparing; }

        int handCount = Integer.compare(this.handCount, otherMinion.handCount);
        if (handCount != 0) { return handCount; }

        return this.minionName.compareTo(otherMinion.minionName);
    }

    @Override
    public int compareTo(Minion otherMinion) {
        // имя - алфавитный, количество символов в имени - возраст (убывание), сумма рук и глаз (возрастание)
        int nameComparing = this.minionName.compareTo(otherMinion.minionName);
        if (nameComparing != 0) { return nameComparing; }

        int lengthComparing = Integer.compare(
                this.minionName.length() - this.age,
                otherMinion.minionName.length() - otherMinion.age);
        if (lengthComparing != 0) { return lengthComparing; }

        int thisSum = this.eyesCount + this.handCount;
        int otherSum = otherMinion.eyesCount + otherMinion.handCount;
        return Integer.compare(thisSum, otherSum);
    }
}
