package com.suchaos.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 与 MyTest21 比较
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.suchaos.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.suchaos.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
