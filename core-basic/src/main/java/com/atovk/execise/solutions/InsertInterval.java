package com.atovk.execise.solutions;



import java.util.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hoducust on 2019/4/4 23H 34m .
 */
public class InsertInterval {

    /**
     * Definition of Interval:
     * public class Interval {
     *     int start, end;
     *     Interval(int start, int end) {
     *         this.start = start;
     *         this.end = end;
     *     }
     * }
     */

    public static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // merge [4,9] in as [1,2],[3,10],[12,16]
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        int size = intervals.size(), curr = 0;
        LinkedList<Interval> result = new LinkedList<>();

        // 如果 要插入的组合头小于 list中的组合尾
        while (curr < size && intervals.get(curr).end < newInterval.start) result.addLast(intervals.get(curr++));

        while (curr < size && intervals.get(curr).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(curr).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(curr).end);
            curr++;
        }
        result.addLast(newInterval);

        while (curr < size) result.addLast(intervals.get(curr++));

        return result;
    }

    // follow up: use one loop
    public List<Interval> insertOneLoop(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();// LinkedList
        int size = intervals.size(), curr = 0;

        for (int i = 0; i < size; i++) {

            if (intervals.get(i).start > newInterval.end) {
                result.add(intervals.get(i));
            } else if (intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
                curr++;
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        result.add(curr, newInterval);
        return result;
    }

    public static void main(String[] args) {
        List<Interval> insert = new InsertInterval().insertOneLoop(
                (List<Interval>) Arrays.asList(new Interval(1, 5)),
                new Interval(0, 0));
    }
}

