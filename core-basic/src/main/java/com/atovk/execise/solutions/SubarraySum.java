package com.atovk.execise.solutions;

import java.util.*;

/**
 * Created by hoducust on 2019/3/31 14H 01m .
 */
public class SubarraySum {

    public List<Integer> solution1(int[] nums) {

        // has some bug
        // [-1,-2,-3,-100,1,2,3,100]
        List<Integer> result = new ArrayList<>(2);
        result.add(0);
        result.add(0);
        // EX: [-3, 1, -4, 2, -4, 2, 1, 1, 1]
        // EX: [-3, 1, -4, -4, 2, 2, 1, 1, 1]
        int size = nums.length;
        int sum = 0;
        int head = 0;
        for (int i = 0; i < size; i++) {

            if (nums[i] == 0) {
                result.add(0, i);
                result.add(1, i);
                break;
            }
            sum += nums[i];
            if (sum == 0) {
                result.add(0, head);
                result.add(1, i);
                break;
            } else {
                if (nums[head] < 0 && nums[i] < 0) {
                    sum = nums[i];
                    head = i;
                }
            }
        }

        return result;
    }

    public List<Integer> solution2(int[] nums) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //if (nums == null || nums.length == 0) return result;
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }
            map.put(sum, i);
        }
        return result;
    }

    public static void main(String[] args) {
        new SubarraySum().solution2(new int[] {-1,-2,-3,-100,1,2,3,100});
    }

}
