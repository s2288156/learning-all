package com.leetcode.offer;

import com.leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * @author Wu.Chunyang
 */
public class LevelOrder3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> req = new ArrayList<>();
        boolean fromLeft = false;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            fromLeft = !fromLeft;
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                if (fromLeft) {
                    TreeNode node = queue.pollFirst();
                    temp.add(node.val);
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                } else {
                    TreeNode node = queue.pollLast();
                    temp.add(node.val);
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                }
            }
            req.add(temp);
        }
        return req;
    }

}
