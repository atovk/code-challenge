package com.atovk.exercise.pattern;


public class Singleton {

    /**
     * 内部类在调用时延迟初始化
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}
