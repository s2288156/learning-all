package com.learning.domain;

import lombok.ToString;

@ToString
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}