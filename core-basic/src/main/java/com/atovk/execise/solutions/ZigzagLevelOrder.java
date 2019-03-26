package com.atovk.execise.solutions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hoducust on 2019/3/26 23H 44m .
 */
public class ZigzagLevelOrder {

    /**
     * Definition of TreeNode:
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left, right;
     *     public TreeNode(int val) {
     *         this.val = val;
     *         this.left = this.right = null;
     *     }
     * }
     */
    private class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<List<Integer>> solution(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int point = 0;
        while (!queue.isEmpty()) {

            List<Integer> integers = new LinkedList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                integers.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            if (point++ % 2 == 0) Collections.reverse(integers);
            result.add(integers);
        }
        return result;
    }


}
