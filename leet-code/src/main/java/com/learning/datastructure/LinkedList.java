package com.learning.datastructure;

import com.learning.domain.ListNode;

/**
 * 链表：
 * - 实现LRU缓存淘汰算法
 * - 约瑟夫（Josephus）问题，41个人，从第一个人开始报数，每报数到3，则第三个人自杀，最后16和31是安全的，用双向链表验证
 *
 * @author wcy
 */
public class LinkedList {
    public static void main(String[] args) {
        ListNode josephus = josephus();
        System.out.println(josephus);
    }

    public static ListNode josephus() {
        ListNode first = new ListNode(1);
        ListNode last = null;
        for (int i = 1; i <= 41; i++) {
            if (i == 41) {
                last.next = first;
            }
            ListNode l = last;
            ListNode newNode = new ListNode(i, null);
            last = newNode;
            if (l == null) {
                first.next = newNode;
            } else {
                l.next = newNode;
            }
        }
        return first;
    }

}
