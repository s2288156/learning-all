package com.leetcode.offer;

import com.leetcode.domain.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
 *
 * @author Wu.Chunyang
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null, curr = head;
        do {
            if (curr.val == val) {
                if (pre == null) {
                    return head.next;
                } else {
                    pre.next = curr.next;
                    return head;
                }
            } else {
                pre = curr;
                curr = curr.next;
            }
        } while (curr != null);
        return head;
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        ListNode root = new ListNode(-3, new ListNode(5, new ListNode(-99)));
        System.out.println(deleteNode.deleteNode(root, -99));

    }
}
