package com.leetcode.offer;

import com.leetcode.domain.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点
 *
 * @author Wu.Chunyang
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int i = -1, j = -1;
        ListNode res = head;
        while (head != null) {
            j++;
            if (j - i == k) {
                if (i != -1) {
                    res = res.next;
                }
                i++;
            }
            head = head.next;
        }
        return i == -1 ? null : res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));
        System.out.println(new GetKthFromEnd().getKthFromEnd(root, 3));
    }
}
