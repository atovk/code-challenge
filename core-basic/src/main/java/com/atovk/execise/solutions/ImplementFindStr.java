package com.atovk.execise.solutions;

import java.util.Arrays;

/**
 * Created by hoducust on 2019/3/23 21H 36m .
 */
public class ImplementFindStr {

    public int Solution(String haystack, String needle){

        return haystack.indexOf(needle);

    }

    public int Solution1(String haystack, String needle) {


        int len = haystack.length();
        int nl = needle.length();
        if(nl == 0) return 0;
        if (nl > len) return -1;

        char[] ne = needle.toCharArray();
        char[] hs = haystack.toCharArray();

        for (int i = 0; i < len; i++) {

            int curr = i;
            for (int j = 0; j < nl; j++) {
                if (hs[curr] == ne[j] && curr < len && len - curr >= nl - j) {
                    curr++;
                } else break;
                if (j == nl - 1) return i;
            }
        }

        return -1;
    }

    private boolean nextMatch(char t){

        return false;
    }


    public static void main(String[] args) {

        System.out.println(new ImplementFindStr().Solution1("mississippi", "issipi"));


    }
}
