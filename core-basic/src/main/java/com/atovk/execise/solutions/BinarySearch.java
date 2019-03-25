package com.atovk.execise.solutions;

/**
 * Created by hoducust on 2019/3/24 21H 41m .
 */
public class BinarySearch {

    public int solution(int[] nums, int target) {
        if(nums.length == 0) return -1;
        return pick(nums, 0, nums.length, target);
    }

    private int pick(int[] nums, int l, int r, int target) {
        int mid = (r - l) / 2 + l;
        if (nums[mid] < target) return pick(nums, mid, r, target);
        else if (nums[mid] > target) return pick(nums, l, mid, target);
        else if (nums[mid] == target) return mid;

        return -1;
    }

    public int solution1(int[] nums, int target) {
        int len = nums.length - 1;
        int l = 0, r = len;
        while (l < r) {
            int mid = (r - l) / 2 + l;

            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().solution1(new int[]{1, 2, 3, 5, 7, 9, 9}, 9));
    }

}
