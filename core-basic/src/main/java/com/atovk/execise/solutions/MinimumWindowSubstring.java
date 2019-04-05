package com.atovk.execise.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hoducust on 2019/4/5 12H 40m .
 */
public class MinimumWindowSubstring {

    public String minWindow(String source , String target) {

        String result = "";
        Map<Character, Integer> letterCnt = new HashMap<>();
        int len = target.length(), i = 0, j = 0, minLen = Integer.MAX_VALUE;

        for (char c : target.toCharArray()) letterCnt.put(c, letterCnt.getOrDefault(c, 0) + 1);

        for (; j < source.length(); j++) {
            if (!letterCnt.containsKey(source.charAt(j))) continue;
            if (letterCnt.get(source.charAt(j)) > 0) len--;
            letterCnt.put(source.charAt(j), letterCnt.get(source.charAt(j)) - 1);

            while (len == 0) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    result = source.substring(i, j + 1);
                }
                if (letterCnt.containsKey(source.charAt(i))) {
                    letterCnt.put(source.charAt(i), letterCnt.get(source.charAt(i)) + 1);
                    if (letterCnt.get(source.charAt(i)) > 0) len++;
                }
                i++;
            }
        }
        return result;
    }




    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("abc", "a");
    }
}
