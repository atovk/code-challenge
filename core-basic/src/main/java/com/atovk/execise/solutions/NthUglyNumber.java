package com.atovk.execise.solutions;

import java.util.HashSet;
import java.util.PriorityQueue;

public class NthUglyNumber {

    public int solution1(int n) {
        if(n<=0) return 0;

        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        Long current = 1L;
        queue.add(current);
        int factors[] = new int[] {2,3,5};
        while (n-- > 0) {
            current = queue.poll();
            for (int factor : factors) {
                if (!set.contains(current * factor)) {
                    queue.add(current * factor);
                    set.add(current * factor);
                }
            }
        }
        return current.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().solution1(10));
    }
}
