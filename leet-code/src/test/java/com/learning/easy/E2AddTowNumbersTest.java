package com.learning.easy;

import com.learning.domain.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wcy
 */
class E2AddTowNumbersTest {

    @Test
    void testAddTwoNumbers() {
        ListNode al1 = new ListNode(2);
        ListNode al2 = new ListNode(4);
        ListNode al3 = new ListNode(3);
        al2.next = al3;
        al1.next = al2;

        ListNode bl1 = new ListNode(5);
        ListNode bl2 = new ListNode(6);
        ListNode bl3 = new ListNode(4);
        bl2.next = bl3;
        bl1.next = bl2;

        E2AddTowNumbers e2AddTowNumbers = new E2AddTowNumbers();

        ListNode listNode = e2AddTowNumbers.addTwoNumbers(al1, bl1);

        assertAll(
                () -> assertEquals(7, listNode.val),
                () -> assertEquals(0, listNode.next.val),
                () -> assertEquals(8, listNode.next.next.val)
                );
    }
}