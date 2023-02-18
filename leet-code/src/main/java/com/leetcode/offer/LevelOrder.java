package com.leetcode.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * @author Jack.Wu
 */
public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        return selfFirstCode(root);
    }

    private static int[] selfFirstCode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<TreeNode> curr;
        List<TreeNode> next = new ArrayList<>();
        List<Integer> orderNums = new ArrayList<>();
        next.add(root);
        do {
            curr = new ArrayList<>(next);
            next.clear();
            curr.forEach(node -> {
                orderNums.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            });
        } while (next.size() > 0);
        return orderNums.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test_case1() {
        LevelOrder code = new LevelOrder();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        int[] ints = {3, 9, 20, 15, 7};
        int[] orderInts = code.levelOrder(node1);
        for (int i = 0; i < ints.length; i++) {
            Assertions.assertEquals(ints[i], orderInts[i]);
        }
    }

    @Test
    public void test_case2() {
        LevelOrder code = new LevelOrder();
        TreeNode node1 = new TreeNode(3);

        int[] ints = {3};
        int[] orderInts = code.levelOrder(node1);
        for (int i = 0; i < ints.length; i++) {
            Assertions.assertEquals(ints[i], orderInts[i]);
        }
    }

    @Test
    public void test_case3() {
        LevelOrder code = new LevelOrder();
        TreeNode node1 = null;

        int[] orderInts = code.levelOrder(node1);
        Assertions.assertEquals(0, orderInts.length);
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
