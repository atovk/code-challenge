package com.atovk.execise.solutions;

public class LeftPad {

    /**
     * @param originalStr: the string we want to append to with spaces
     * @param size: the target length of the string
     * @return: A string
     */
    public static String leftPad(String originalStr, int size) {
        // Write your code here
        int osize = size - originalStr.length();
        while (osize-- > 0) {
            originalStr = " " + originalStr;
        }
        return originalStr;
    }

    /*
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    public static String leftPad(String originalStr, int size, char padChar) {
        // write your code here
        int osize = size - originalStr.length();
        while (osize-- > 0) {
            originalStr = padChar + originalStr;
        }
        return originalStr;
    }

    public static void main(String[] args) {
        String abc = LeftPad.leftPad("ABC", 4, 'Q');
    }
}
