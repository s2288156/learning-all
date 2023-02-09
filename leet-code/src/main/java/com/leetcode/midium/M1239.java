package com.leetcode.midium;

import java.util.ArrayList;
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

    int ans = 0;

    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                // != 0 说明存在重复字符
                if ((mask >> ch & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;
            }
            if (mask != 0) {
                masks.add(mask);
            }
        }
        traceback(masks, 0, 0);

        return ans;
    }

    public void traceback(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        // 无重复字符，mask添加字符，并进入下一层递归; 0000 & 0001 = 0000 / 0001 & 0001 = 0001
        if ((mask & masks.get(pos)) == 0) {
            traceback(masks, pos + 1, mask | masks.get(pos));
        }

        // 有重复字符，mask不变，进入下一层递归
        traceback(masks, pos + 1, mask);
    }

}
