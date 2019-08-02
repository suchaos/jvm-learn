package com.suchaos.jvm.memory;

/**
 * TODO description class
 *
 * @author suchao
 * @date 2019/4/30
 */
public class Test {

    public static void main(String[] args) {
        String abc = "abc";
        String d = "d";
        String s = new StringBuilder(abc).append(d).toString();
        System.out.println(s.intern() == s);

        s = new StringBuilder("abc").append("d").toString();
        System.out.println(s.intern() == s);

        String a = "abc" + "d";
        System.out.println(a.intern() == a);
        a = "abc" + "d";
        System.out.println(a.intern() == a);

        String b = new String("aaa");
        System.out.println(b.intern() == b);
    }
}
