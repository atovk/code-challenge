package com.atovk.exercise.pattern;

/**
 * lazy N
 * safety Y
 */
public enum Singleton {

    /**
     * 默认实例化
     */
    INSTANCE;

    public void balabala() {
    }

    public static void main(String[] args) {
        Singleton.INSTANCE.balabala();
    }

}
