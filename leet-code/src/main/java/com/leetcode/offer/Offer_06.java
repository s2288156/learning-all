package com.leetcode.offer;

import com.leetcode.domain.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * @author Wu.Chunyang
 */
public class Offer_06 {

    private List<Integer> temp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        deepNext(head);
        int[] reverse = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            reverse[i] = temp.get(i);
        }
        return reverse;
    }

    public void deepNext(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            deepNext(node.next);
        }
        temp.add(node.val);
    }

    @Test
    public void test_case1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        Offer_06 offer06 = new Offer_06();
        int[] ints = offer06.reversePrint(node1);
        System.out.println(Arrays.toString(ints));
    }
}
