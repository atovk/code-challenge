package com.atovk.execise;

public class TestMain {

    int a = 20;

    public static void main(String[] args) {

/*
        int a = 10;
        int b = 20;
        int c = 10;

        c = sum(a, b);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

*/

        int s = 0;
        while (s < 20) {
            System.out.println(s++);
        }

        for (int i = 0; i < 20; i++) {

        }




    }

    private static int sum(int a, int b) {
        a = a + 1;
        return a + b;
    }

}
