package com.atovk.execise.solutions;

import java.util.*;

/**
 * Created by hoducust on 2019/4/2 22H 03m .
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;

        Arrays.sort(nums);
        // DFS nack tracking
        dfs(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {

            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

                visited[i] = true;
                temp.add(nums[i]);
                dfs(nums, result, temp, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }



    public static void main(String[] args) {

        new PermutationsII().permuteUnique(new int[]{1, 2, 3});

    }
}
