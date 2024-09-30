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
        return "Minion: " +
                "minionName='" + minionName + '\'' +
                ", eyesCount=" + eyesCount + '\n' +
                ", age=" + age;
    }

    public int compareTo(Minion otherMinion) {
        int eyesComparing = Integer.compare(this.eyesCount, otherMinion.eyesCount);
        if (eyesComparing != 0) { return eyesComparing; }

        int ageComparing = Integer.compare(this.age, otherMinion.age);
        if (ageComparing != 0) { return ageComparing; }

        return this.minionName.compareTo(otherMinion.minionName);
    }
}
