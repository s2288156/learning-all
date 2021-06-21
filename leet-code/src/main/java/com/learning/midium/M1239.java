package com.learning.midium;

import java.util.List;

/**
 * 串联字符串的最大长度:
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 *
 * @author wcy
 */
public class M1239 {

    public int maxLength(List<String> arr) {
        int arrSize = arr.size();
        if (arrSize == 1) {
            return arr.get(0).length();
        }
        // 有效最大长度，默认-1
        int validLength = -1;
        /**
         * 有效的串联：
         * 1. 无重复字符
         *
         * 无效的串联：
         * 1. 相加长度超过26
         * 2. 重复的字符: 遍历对比
         */
        for (int i = 0; i < arrSize; i++) {
            StringBuilder appendStr = new StringBuilder(arr.get(i));
            for (int j = i + 1; j < arrSize; j++) {
                String jStr = arr.get(j);

                // 判断是否有重复字符，如果重复，则跳过内层for(int j...)循环
                boolean charRepetition = false;
                char[] iStrChars = appendStr.toString().toCharArray();
                char[] jStrChars = jStr.toCharArray();
                for (char iStrChar : iStrChars) {
                    for (char jStrChar : jStrChars) {
                        // 字符重复，则allBreak = true
                        if (charRepetition = (iStrChar == jStrChar)) {
                            break;
                        }
                    }
                    if (charRepetition) {
                        break;
                    }
                }
                if (charRepetition) {
                    continue;
                }

                // 字符无重复，则进行append操作，判断长度是否超过26
                if ((appendStr.length() + jStr.length()) > 26) {
                    continue;
                }
                appendStr.append(jStr);

                // 确认长度，保存最长的一次结果
                int appendStrLength = appendStr.length();
                validLength = Math.max(appendStrLength, validLength);
            }
        }

        return validLength;
    }
}
