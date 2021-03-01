package com.asktao.sample;

/**
 * @author wcy
 */
public class Demo {
    public static void main(String[] args) {
        String[] tags = new String[]{MqConst.TAG_A, MqConst.TAG_B, MqConst.TAG_C};
        for (int i = 0; i < 10; i++) {
            System.out.println(i % tags.length);
        }
    }
}
