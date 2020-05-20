package com.atovk.exercise.pattern;

public class Singleton {

    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}
