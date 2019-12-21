package com.atovk.execise;

import java.util.*;
import java.util.stream.Collectors;

public class Lamda {

    public static void main(String[] args) {

        String a = "bcb";


        System.out.println(check(a));

    }

    static boolean check(String cc) {
        return cc!= null && cc.contains("bb");
    }

}
