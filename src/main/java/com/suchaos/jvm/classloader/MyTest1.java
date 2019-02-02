package com.suchaos.jvm.classloader;

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求其父类全部已经初始化完毕
 *
 * @author suchao
 * @date 2019/2/2
 */
public class MyTest1 {
    public static void main(String[] args) {
        /**
         * 输出结果
         *    MyParent1 static block
         *    hello world
         */
        //System.out.println(MyChild1.str);
        /**
         * 输出结果
         *    MyParent1 static block
         *    MyChild1 static block
         *    Welcome
         */
        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "Welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}
