package com.suchaos.jvm.classloader;

import java.util.UUID;

/**
 * 编译时常量 VS 运行时常量
 *
 * 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中去，
 * 这时在程序运行是，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
 *
 * @author suchao
 * @date 2019/2/2
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static block");
    }
}
