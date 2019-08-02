package com.suchaos.jvm.bytecode;

import java.util.*;

/**
 * 数组初始化
 *
 * @author suchao
 * @date 2019/2/17
 */
public class ArrayTest {
    public static void main(String[] args) {
        //MyInterface myInterface = new MyInterface();
//        MyInterface[] myInterfaces = new MyInterface[3];
//
//        myInterfaces[0] = new MyClass();
//        myInterfaces[2] = new MyClass();
//
//        Set<String> set = new HashSet<>();
//        set.add("hhh");
//        set.add(null);
//        set.add("nihao");
//
//        for (String s : set) {
//            System.out.println(s);
//        }
        int a = 1;
        int b = 2;
        if (a == 4 || (b = 3) == 5) {
            System.out.println("test");
        }
        System.out.println(a);
        System.out.println(b);

        ArrayTest arrayTest = new ArrayTest();
        System.out.println(arrayTest.getDate(new Date() {
        }));

    }

    public String getDate(Date date) {
        return date.toString();
    }

    public String getDate2(String date) {
        return date.toString();
    }

    public void method1(List<Object> list) {

    }

    public void method2() {
        method1(new ArrayList<Object>());
//        method1(new ArrayList<String>());
//        method1(new ArrayList<Integer>());
    }

    public void method3(List<? extends Object> list) {

    }

    public void method4() {
        method3(new ArrayList<Object>());
        method3(new ArrayList<String>());
        method3(new LinkedList<Integer>());
    }

    public void method5(List<?> list) {

    }

    public void method6() {
        method5(new ArrayList<Object>());
        method5(new ArrayList<String>());
        method5(new LinkedList<Integer>());
    }
}

interface MyInterface {

}

class MyClass implements MyInterface {

}
