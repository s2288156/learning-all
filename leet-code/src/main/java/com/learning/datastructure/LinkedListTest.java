package com.learning.datastructure;

import com.learning.domain.ListNode;

/**
 * 链表：
 * - 实现LRU缓存淘汰算法
 * - 约瑟夫（Josephus）问题，41个人，从第一个人开始报数，每报数到3，则第三个人自杀，最后16和31是安全的，用双向链表验证
 *
 * @author wcy
 */
public class LinkedListTest {


    public static void main(String[] args) {
        ListNode lifePeople = josephus();
        for (int i = 0; i < 39; i++) {
            lifePeople = threeKillOne(lifePeople);
            System.out.println(lifePeople);
        }
        int lifeOne = lifePeople.val;
        int lifeTwo = lifePeople.next.val;
        System.out.printf("one = %s, two = %s%n", lifeOne, lifeTwo);
    }

    public static ListNode threeKillOne(ListNode listNode) {
        ListNode killNext = null;
        for (int i = 1; i < 3; i++) {
            killNext = listNode.next;
        }
        ListNode life = killNext.next.next;
        killNext.next = life;
        return killNext.next;
    }

    public static ListNode josephus() {
        final int morePeople = 11;
        ListNode first = new ListNode(1);
        ListNode last = null;
        for (int i = 2; i <= morePeople; i++) {
            ListNode l = last;
            ListNode newNode = new ListNode(i, null);
            last = newNode;
            if (l == null) {
                first.next = newNode;
            } else if (i == morePeople) {
                last.next = first;
            } else {
                l.next = newNode;
            }
        }
        System.out.println("first = " + first);
        System.out.println("last = " + last + ", next = " + last.next);
        return last.next;
    }

}
