package com.demo.multithread;

import lombok.SneakyThrows;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wuyang
 */
public class CasMain {
    private  int sizeCtl = 16;

    public static Unsafe createUnsafe() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get(null);
            return unsafe;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    private void casInt() {
        Unsafe unsafe = createUnsafe();
        long SIZECTL = unsafe.objectFieldOffset(this.getClass().getDeclaredField("sizeCtl"));
        int sc = 16;
        boolean casUnsafe = unsafe.compareAndSwapInt(this, SIZECTL, sc, -1);
        System.out.println("sc = " + sc);
        System.out.println("casUnsafe = " + casUnsafe);
        System.out.println(SIZECTL);
    }

    public static void main(String[] args) {
        CasMain casMain = new CasMain();
        casMain.casInt();
    }
}
