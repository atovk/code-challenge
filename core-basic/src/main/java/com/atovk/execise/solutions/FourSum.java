package com.atovk.execise.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hoducust on 2019/4/9 22H 14m .
 */
public class FourSum {


    public List<List<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (numbers.length < 4) return ans;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) continue;
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) continue;
                int low = j + 1, high = numbers.length - 1;
                while (low < high) {
                    int sum = numbers[i] + numbers[j] + numbers[low] + numbers[high];
                    if (sum == target) {
                        ans.add(Arrays.asList(numbers[i], numbers[j], numbers[low], numbers[high]));
                        while (low < high && numbers[low] == numbers[low + 1]) low++;
                        while (low < high && numbers[high] == numbers[high - 1]) high--;
                        low++;
                        high--;
                    } else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{1, 2, 3, 5, 7, 2, 8, 9, 19, 11}, 23);
    }
}
