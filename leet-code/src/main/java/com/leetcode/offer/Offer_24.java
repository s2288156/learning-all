package com.leetcode.offer;

import com.leetcode.domain.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author Wu.Chunyang
 */
public class Offer_24 {

    public ListNode reverseList(ListNode head) {
        return iteration(head);
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static ListNode iteration(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
