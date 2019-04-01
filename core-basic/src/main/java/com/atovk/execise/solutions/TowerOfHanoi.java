package com.atovk.execise.solutions;

import scala.collection.mutable.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by hoducust on 2019/4/1 22H 04m .
 */
public class TowerOfHanoi {

    public List<String> solution(int n) {

        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> c = new Stack<>();

        List<String> result = new ArrayList<>();

        int currentMin = 1;
        int as = n;
        while (as-- > 0) a.push(n);

        while (c.size() == n) {




        }
        return result;
    }

    public List<String> solution2(int n) {
        List<String> result = new ArrayList<>();
        exchange(result, n, 'A', 'B', 'C');
        return result;
    }

    private void exchange(List<String> res, int n, char a, char b, char c) {

        if (n == 1) {
            res.add("from " + a + " to " + c);
        } else {
            exchange(res, n - 1, a, c, b);
            res.add("from " + a + " to " + c);
            exchange(res, n - 1, b, a, c);
        }
    }




    public static void main(String[] args) {
        new TowerOfHanoi().solution2(3);
    }

}
