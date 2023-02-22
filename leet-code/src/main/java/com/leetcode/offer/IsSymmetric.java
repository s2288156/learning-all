package com.leetcode.offer;

import com.leetcode.domain.TreeNode;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * @author Wu.Chunyang
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && recur(left.left, right.right) && recur(left.right, right.left);
    }
}
