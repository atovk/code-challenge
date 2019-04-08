package com.atovk.execise.solutions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by hoducust on 2019/4/8 22H 06m .
 */
public class MinStack {

    private int min;
    private Deque<Integer> stack;

    public MinStack() {
        // do intialization if necessary
        stack = new LinkedList<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (stack.isEmpty()) {
            stack.push(0);
            min = number;
        } else {
            stack.push(number - min);
            if (number < min) min = number;
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int res = Integer.MAX_VALUE;
        if (stack.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            // pop top value
            res = stack.peek() < 0 ? min : stack.peek() + min;
            // update min
            int v = stack.pop();
            if (v < 0) min = min - v;
        }
        return res;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        if (stack.isEmpty()) throw new NoSuchElementException();
        return min;
    }
}
