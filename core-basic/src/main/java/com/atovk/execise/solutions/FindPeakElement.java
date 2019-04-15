package com.atovk.execise.solutions;

public class FindPeakElement {

    // [1,2,3,4,3,5,7,9,1]
    public int findPeak(int[] A) {

        int l = 0, r = A.length - 1, mid = -1;
        while (l + 1 < r) {
            mid = (r - l) / 2 + l;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1]) {
                l = mid;
            } else if (A[mid] > A[mid + 1]) {
                r = mid;
            }
        }
        if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) return mid;
        return -1;
    }

    public int findPeak2(int[] A) {

        int l = 0, r = A.length -1, mid = -1;
        while (l + 1 < r) {
            mid = (r - l) / 2 + l;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                return mid;
            } else if (A[mid] < A[mid - 1]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return -1;
    }
}
