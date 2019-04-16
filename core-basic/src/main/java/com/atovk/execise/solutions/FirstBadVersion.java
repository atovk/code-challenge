package com.atovk.execise.solutions;

/**
 * Created by hoducust on 2019/4/14 21H 47m .
 */
public class FirstBadVersion {

    public static class SVNRepo {
        public static boolean isBadVersion(int k) {
            return false;
        }
    }

    public int findFirstBadVersion(int n) {

        int l = 1, r = n, mid;

        while (l + 1 < r) {
            mid = (r - l) / 2 + l;
            if (SVNRepo.isBadVersion(mid)) {
                r = mid;
            } else l = mid;
        }

        if (SVNRepo.isBadVersion(l)) {
            return l;
        } else if (SVNRepo.isBadVersion(r)) {
            return r;
        } else return -1;
    }
}




