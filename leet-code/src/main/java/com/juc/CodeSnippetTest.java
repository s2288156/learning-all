package com.juc;

import org.openjdk.jol.info.ClassLayout;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Wu.Chunyang
 */
public class CodeSnippetTest {
    public static void main(String[] args) {
        // LocalDateTime d = LocalDateTime.now();
        // System.out.println(d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        UserObj uo = new UserObj();
        System.out.println(ClassLayout.parseInstance(uo).toPrintable());
        UserObjMt uom = new UserObjMt();
        System.out.println(ClassLayout.parseInstance(uom).toPrintable());
    }
}

class UserObj {
    String name;
    int age;
}

class UserObjMt {
    String name;
    int age;

    public void print() {
        System.out.println("name: " + name + ", age: " + age);
    }
}
