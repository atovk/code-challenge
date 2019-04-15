package com.atovk.execise.solutions;

import java.util.HashSet;

public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();

        for (Integer i : nums1) temp.add(i);
        for (Integer e : nums2) {
            if (temp.contains(e)) result.add(e);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
