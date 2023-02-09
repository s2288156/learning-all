package com.leetcode.easy;

import com.leetcode.domain.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
class E501FindModeTest {

    @Test
    void testFindMode() {
        TreeNode node1 = new TreeNode(1);
        node1.right = new TreeNode(2);
        node1.right.left = new TreeNode(2);

        E501FindMode e501FindMode = new E501FindMode();
        int[] mode = e501FindMode.findMode(node1);
        assertEquals(2, mode[0]);
    }
}
