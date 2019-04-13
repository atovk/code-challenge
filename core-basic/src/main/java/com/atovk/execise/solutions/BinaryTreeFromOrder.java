package com.atovk.execise.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hoducust on 2019/4/13 23H 06m .
 */
public class BinaryTreeFromOrder {


    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int pres, int pree, int[] inorder, int ins, int ine, Map<Integer, Integer> dict) {

        if (pres > pree || ins > ine) return null;
        int val = preorder[pres];
        int index = dict.get(val);
        TreeNode node = new TreeNode(val);
        node.left = build(preorder, pres + 1, index - ins + pres, inorder, ins, index - 1, dict);
        node.right = build(preorder, pres + index - ins + 1, pree, inorder, index + 1, ine, dict);

        return node;
    }


}
