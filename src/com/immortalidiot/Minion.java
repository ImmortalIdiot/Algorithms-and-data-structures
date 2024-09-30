package com.immortalidiot;


public class Minion {

    private final String minionName;
    private final int eyesCount;
    private int age;

    public Minion(String minionName, int eyesCount) {
        this.minionName = minionName;
        this.eyesCount = eyesCount;
    }

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
}
