package com.leetcode.offer;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"
 *
 * @author Wu.Chunyang
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int i = s.length() - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "  a b c    ";
        System.out.println(new ReverseWords().reverseWords(s));
    }
}
