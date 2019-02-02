package com.suchaos.jvm.classloader;

import java.util.Random;

/**
 * 接口
 *
 * 因为其变量都是 public static final
 * 如果是编译期间就可以确定的常量，那么会在调用这个变量的那个类的常量池中
 *
 * 但如果是运行期常量，则会初始化这个类以及其父类
 *
 * @author suchao
 * @date 2019/2/2
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.c);
    }
}

interface MyParent5 {
    int a = 5;
}

interface MyChild5 extends MyParent5 {
    int b = 6;
    int c = new Random().nextInt(2);

}
