package com.immortalidiot;


public class Minion {

    private final String minionName;
    private final int eyesCount;

    public Minion(String minionName, int eyesCount) {
        this.minionName = minionName;
        this.eyesCount = eyesCount;
    }

    @Override
    public String toString() {
        return "Minion: " +
                "minionName='" + minionName + '\'' +
                ", eyesCount=" + eyesCount;
    }
}
