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
        ListNode currA = headA, currB = headB;
        while (currB != null) {
            if (currA == currB) {
                return currA;
            }
            if (currB.next == null && currA.next != null) {
                currA = currA.next;
                currB = headB;
            } else {

            }
        }
        return null;
    }
}
