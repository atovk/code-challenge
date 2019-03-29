package com.atovk.execise.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hoducust on 2019/3/29 22H 18m .
 */
public class PreviousPermutation {

    public List<Integer> copyedSolution(List<Integer> nums) {

        int size = nums.size();
        if (size <= 1) return nums;

        int i = size - 1;
        while (i > 0 && nums.get(i) >= nums.get(i - 1)) i--;

        for (int j = i, k = size - 1; j < k; j++) {
            int tmp = nums.get(i);
            nums.set(j, nums.get(k));
            nums.set(k, tmp);
            k--;
        }

        if (i != 0) {
            int j = i;
            while (j < size) {
                if (nums.get(j) < nums.get(i - 1)) {
                    int tmp = nums.get(j);
                    nums.set(j, nums.get(i - 1));
                    nums.set(i - 1, tmp);
                }
                j++;
            }
        }
        return nums;
    }


    public List<Integer> copyedSolution2(List<Integer> nums) {

        if (nums == null || nums.size() <= 1) return nums;

        int index = nums.size() - 2;
        while (index >= 0) {
            //逆序通过判断数组中前后大小：后面总是比前面大，判定数组所在状态为第几个可能状态
            if (nums.get(index) > nums.get(index + 1)) break;
            index--;
        }
        // 有序情况下，直接返回数组逆序
        if (index == -1) {
            Collections.reverse(nums);
            return nums;
        }
        // 通过数组的状态，交换元素位置（依次交换外层位置）
        int changeNumber = nums.get(index);
        for (int swapIndex = nums.size() - 1; swapIndex > index; swapIndex--) {
            if (nums.get(swapIndex) < changeNumber) {
                Collections.swap(nums, swapIndex, index);
                break;
            }
        }
        // 交换最后一个位置的元素
        Collections.reverse(nums.subList(index + 1, nums.size()));
        return nums;

    }


    public static void main(String[] args) {
        List<Integer> integers = new PreviousPermutation().copyedSolution2(Arrays.asList(1,4,2,3));
        System.out.println(integers);
    }

}

