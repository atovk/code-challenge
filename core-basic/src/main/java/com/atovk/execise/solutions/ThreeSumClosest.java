package com.atovk.execise.solutions;

import java.util.Arrays;

/**
 * Created by hoducust on 2019/4/10 22H 31m .
 */
public class ThreeSumClosest {


    /**
     * 前提： 如果保证结果唯一，需要将元素进行排序（排除重复元素，导致的结果重复）
     *
     * @param numbers
     * @param target
     * @return
     */
    public int threeSumClosest(int[] numbers, int target) {
        int result = numbers[0] + numbers[1] + numbers[numbers.length - 1];
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                int a = Math.abs(sum - target);
                int b = Math.abs(result - target);
                // more close target
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new ThreeSumClosest().threeSumClosest(new int[]{2, 7, 11, 15}, 3);
    }
}
