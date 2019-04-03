package com.atovk.execise.solutions;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by hoducust on 2019/4/3 21H 52m .
 */
public class InterleavingString {


    /**
     *  DP 解
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        int n1 = s1.length(), n2 = s2.length();

        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; ++i) {

            for (int j = 0; j <= n2; ++j) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] =
                            dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) ||
                                    dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        new InterleavingString().isInterleave("", "", "");
    }

}
