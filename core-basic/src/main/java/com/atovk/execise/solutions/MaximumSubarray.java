package com.atovk.execise.solutions;

/**
 * Created by hoducust on 2019/3/28 22H 05m .
 */
public class MaximumSubarray {

    public int solution1(int[] nums) {
        int max = Integer.MIN_VALUE, current = Integer.MIN_VALUE;

        for (int i : nums) {
            if (current > 0) current += i;
            else current = i;
            max = Integer.max(max, current);
        }
        return max;
    }

    public static void main(String[] args) {
        new MaximumSubarray().solution1(new int[]{-2,2,-3,4,-1,2,1,-5,3});
    }
}
