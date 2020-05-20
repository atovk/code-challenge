package com.atovk.exercise.pattern;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    /**
     * 锁住类方法, 保证线程安全
     */
    public static synchronized Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }


    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
