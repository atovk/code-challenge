package com.atovk.execise.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hoducust on 2019/3/30 21H 31m .
 */
public class FizzBuzz {

    public List<String> solution(int n) {


        List<String> result = new ArrayList<>();
        int i = 0;
        while (i++ < n) {

            if (i % 15 == 0) {
                result.add("fizz buzz");
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else if (i % 3 == 0) {
                result.add("fizz");
            } else result.add(String.valueOf(i));

        }
        return result;
    }

}
