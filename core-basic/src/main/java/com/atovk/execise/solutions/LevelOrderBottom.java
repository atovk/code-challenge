package com.atovk.execise.solutions;

import java.util.*;

/**
 * Created by hoducust on 2019/3/25 22H 24m .
 */
public class LevelOrderBottom {

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
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    public List<List<Integer>> solution1(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> integers = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                integers.add(current.val);
            }
            if (!integers.isEmpty()) list.add(integers);
        }
        Collections.reverse(list);
        return list;
    }


    public static void main(String[] args) {

    }

}
