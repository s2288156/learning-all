package com.leetcode.offer;

import com.leetcode.domain.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 公共节点是指，在内存上是同一个对象，值相同的节点不代表是公共节点。
 *
 * @author Wu.Chunyang
 */
public class GetIntersectionNode {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
}
