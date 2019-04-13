package com.atovk.execise.solutions;

/**
 * Created by hoducust on 2019/4/12 23H 03m .
 */
public class SearchRotatedSortedArray {

    /**
     *
     * @param A
     * @param target
     * @return
     */

    public int search(int[] A, int target) {

        if (A == null || A.length == 0) return -1;
        int l = 0, r = A.length - 1, mid;

        while (l + 1 < r) {
            mid = (r - l) / 2 + l;
            if (A[mid] == target) {
                return mid;
            } else if (A[l] < A[mid]) {
                if (A[mid] >= target && A[l] <= target) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                if (A[mid] <= target && target <= A[r]) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }
        if (A[l] == target) return l;
        if (A[r] == target) return r;
        return -1;
    }
}
