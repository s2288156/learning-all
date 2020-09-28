package com.learning.easy;

import com.learning.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *    int val;
 *    TreeNode left;
 *    TreeNode right;
 *    TreeNode(int x) { val = x; }
 * }
 * </pre>
 * <p>https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/</p>
 *
 * @author wcy
 */
public class E501FindMode {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> statistic = new HashMap<>(1024);
        statistic.merge(root.val, 1, Integer::sum);

        System.out.println(statistic.toString());
        return null;
    }

}
