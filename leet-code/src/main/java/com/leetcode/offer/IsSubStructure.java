package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * @author Wu.Chunyang
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (A != null) {
            queue.add(A);
        }
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (compare(node, B)) {
                    return true;
                }
                enqueueSub(queue, node);
            }
        }

        return false;
    }

    private boolean compare(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return compare(a.left, b.left) && compare(a.right, b.right);
    }

    private static void enqueueSub(Queue<TreeNode> queue, TreeNode node) {
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }

    @Test
    public void test_case1() {
        TreeNode nodeA1 = new TreeNode(1);
        TreeNode nodeA2 = new TreeNode(2);
        TreeNode nodeA3 = new TreeNode(3);
        nodeA1.left = nodeA2;
        nodeA1.right = nodeA3;

        TreeNode nodeB1 = new TreeNode(3);
        TreeNode nodeB2 = new TreeNode(1);
        nodeB1.left = nodeB2;

        IsSubStructure isSubStructure = new IsSubStructure();
        Assertions.assertFalse(isSubStructure.isSubStructure(nodeA1, nodeB1));
    }

    @Test
    public void test_case2() {
        TreeNode nodeA1 = new TreeNode(3);
        TreeNode nodeA2 = new TreeNode(4);
        TreeNode nodeA3 = new TreeNode(5);
        TreeNode nodeA4 = new TreeNode(1);
        TreeNode nodeA5 = new TreeNode(2);
        nodeA1.left = nodeA2;
        nodeA1.right = nodeA3;
        nodeA2.left = nodeA4;
        nodeA2.right = nodeA5;

        TreeNode nodeB1 = new TreeNode(4);
        TreeNode nodeB2 = new TreeNode(1);
        nodeB1.left = nodeB2;

        IsSubStructure isSubStructure = new IsSubStructure();
        Assertions.assertTrue(isSubStructure.isSubStructure(nodeA1, nodeB1));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
