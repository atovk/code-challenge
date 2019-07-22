package com.atovk.execise.concurrent;

public class RaceConditionTest {

    public static void main(String[] args) {
        // 共享对象
        RaceCondition raceCondition = new RaceCondition();
        int size = 10;
        while (size-- > 0) {
            new Thread(() -> {
                // 同一时刻，存在多个线层访问add10K的情况
                raceCondition.add10K();
                System.out.println(raceCondition.count);
            }).start();

        }
    }

    public static class RaceCondition {
        private long count = 0;

        synchronized long get() {
            return count;
        }

        synchronized void set(long v) {
            count = v;
        }

        // 未加锁存在 竞态条件
        synchronized void add10K() {
            int idx = 0;
            while (idx++ < 100000) {
                set(get() + 1);
            }
        }
    }


}
