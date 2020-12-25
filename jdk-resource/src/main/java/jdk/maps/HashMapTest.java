package jdk.maps;

import java.util.HashMap;

/**
 * @author wcy
 */
public class HashMapTest {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        HashMap<Object, Object> hashMap = new HashMap<>(Integer.MAX_VALUE);

        // 无符号右位移运算, >>> 32 等价于 >>> 0, 等价于无变化
        System.out.println("无符号右位移运算");
        System.out.println("-1 >>> 32 = " + (-1 >>> 32));
        System.out.println("-1 >>> 0 = " + (-1 >>> 0));

//        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

        // if i = 1 << 16, n = 31;   n - 16 = 15; i >>> 16 = ?; return n - (i >>> 1)
        System.out.println("i = 1, i << 16 = " + (1 << 16));
        System.out.println("i: 65536 >>> 16 = " + (65536 >>> 16));
        System.out.println("1 >>> 1 = " + (1 >>> 1));
        System.out.println("n = 15, i = 1; 15 - (i >>> 1) = " + (15 - (1 >>> 1)));
        System.out.println("int n = -1 >>> 15 = " + (-1 >>> 15));


    }
}
