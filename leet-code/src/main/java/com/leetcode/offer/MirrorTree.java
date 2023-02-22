package com.leetcode.offer;

import com.leetcode.domain.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author Wu.Chunyang
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }


    @Test
    void test_case1() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        MirrorTree mirrorTree = new MirrorTree();
        TreeNode result = mirrorTree.mirrorTree(node1);
        Assertions.assertEquals(4, result.val);
        Assertions.assertEquals(7, result.left.val);
        Assertions.assertEquals(2, result.right.val);
        Assertions.assertEquals(9, result.left.left.val);
        Assertions.assertEquals(6, result.left.right.val);
        Assertions.assertEquals(3, result.right.left.val);
        Assertions.assertEquals(1, result.right.right.val);
    }

    @Test
    void test_case2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        MirrorTree mirrorTree = new MirrorTree();
        TreeNode result = mirrorTree.mirrorTree(node1);
        Assertions.assertEquals(1, result.val);
        Assertions.assertNull(result.left);
        Assertions.assertEquals(2, result.right.val);
    }

    @Test
    void test_case3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;

        MirrorTree mirrorTree = new MirrorTree();
        TreeNode result = mirrorTree.mirrorTree(node1);
        Assertions.assertEquals(1, result.val);
        Assertions.assertNull(result.right);
        Assertions.assertEquals(2, result.left.val);
    }
}
