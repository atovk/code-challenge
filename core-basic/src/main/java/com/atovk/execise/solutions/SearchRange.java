package com.atovk.execise.solutions;

public class SearchRange {

    public int[] searchRange(int[] A, int target) {

        if (A.length == 0) return new int[]{-1, -1};
        int[] result = new int[2];
        int l = 0, r = A.length - 1, mid;
        // 左边查找下标
        while (l + 1 < r) {
            mid = (r - l) / 2 + l;
            if (A[mid] < target) {
                l = mid;
            } else if (A[mid] > target) {
                r = mid;
            } else r = mid;
        }

        if (A[r] == target) {
            result[0] = r;
        } else if (A[l] == target) {
            result[0] = l;
        } else {
            result[0] = result[1] = -1;
            return result;
        }

        l = 0;
        r = A.length - 1;
        // 右边查找下标
        while (l + 1 < r) {
            mid = (r - l) / 2 + l;
            if (A[mid] < target) {
                l = mid;
            } else if (A[mid] > target) {
                r = mid;
            } else l = mid;
        }

        if (A[l] == target) {
            result[1] = l;
        } else if (A[r] == target) {
            result[1] = r;
        } else {
            result[0] = result[1] = -1;
            return result;
        }
        return result;
    }

    public int[] searchRange2(int[] A, int target) {

        int[] bound = new int[2];
        if (A.length == 0) return new int[]{-1, -1};
        int start, end, mid;

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = (end = start) / 2 + start;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else end = mid;
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = (end = start) / 2 + start;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else end = mid;
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        return bound;
    }
}
