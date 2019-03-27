package com.atovk.execise.solutions;

import java.util.*;

/**
 * Created by hoducust on 2019/3/27 21H 34m .
 */
public class NestedIntegerFlatten {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer,
     *     // rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds,
     *     // if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds,
     *     // if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public List<Integer> solution(List<NestedInteger> nestedList) {

        List<Integer> result = new LinkedList<>();
        Deque<NestedInteger> queue = new LinkedList<>();
//        nestedList.forEach(item -> queue.add(item));
        queue.addAll(nestedList);

        int point = 0;
        while (!queue.isEmpty()) {

            NestedInteger current = queue.poll();
            if (current.isInteger()) {
                if (point-- == 0) {
                    result.add(current.getInteger());
                } else {
                    result.add(0, current.getInteger());
                }
            } else {
                for (NestedInteger item:current.getList()) {
                    queue.addFirst(item);
                    point++;
                }
            }
        }
        return new ArrayList<>(result);
    }





}
