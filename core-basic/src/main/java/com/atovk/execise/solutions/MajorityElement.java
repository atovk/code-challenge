package com.atovk.execise.solutions;



import java.util.Arrays;
import java.util.List;

/**
 * Created by hoducust on 2019/4/7 20H 33m .
 */
public class MajorityElement {

    public int sortMajorityNumber(List<Integer> nums) {

        int count = 0, nexCount = 0, major = nums.get(0);

        for (int i = 0; i < nums.size(); i++) {

            if (nums.get(i) == major) {
                count++;
            } else if (nums.get(i) != major) {
                nexCount++;
            }

            if (nexCount > count) {
                major = nums.get(i);
                count = nexCount;
            }

            if (count >= nums.size() / 2) break;
        }
        return major;
    }

    public int majorityNumber(List<Integer> nums) {

        int currNumber = nums.get(0), count = 1;
        for (int i = 1; i < nums.size(); i++) {
            int number = nums.get(i);
            if (count == 0) currNumber = number;
            if ((number == currNumber)) {
                count++;
            } else {
                count--;
            }
        }
        return currNumber;
    }

    public static void main(String[] args) {
        new MajorityElement().majorityNumber(Arrays.asList(1,2,3,3,1,2,1));
    }
}
