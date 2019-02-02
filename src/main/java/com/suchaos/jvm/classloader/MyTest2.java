package com.suchaos.jvm.classloader;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池当中
 *
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发
 * 定义常量的类的初始化
 *
 * 注意：这里指的是将常量存放到了 MyTest2 的常量池中，之后 MyTest2 和 MyParent2 就没有任何关系了
 * 甚至，我们可以将 MyParent2 的 class 文件删除
 *
 * E:\learn\jvm_lecture\target\classes>javap -c com.suchaos.jvm.classloader.MyTest2
 *
 * 助记符：
 * 官网：https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html
 *
 * iconst_1 表示将 int 类型 1 推送至栈顶 （-1 ~ 5 , iconst_m1 ~ iconst_0 ~ iconst_5, 6的话，变为 bipush 6）
 * bipush 表示将单字节 （-128 ~ 127）的常量值推送到栈顶
 * sipush 表示将一个短整形常量值（-32768 ~ 32767）推送到栈顶
 * ldc 表示将 int, float 或是 String 类型的常量值从常量池推送至栈顶
 *
 * @author suchao
 * @date 2019/2/2
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.m);
    }
}

class MyParent2 {
    /**
     * 加 final 则不输出 "MyParent2 static block"
     */
    public static final String str = "hello world";
    //public static String str = "hello world";

    public static final short s = 7;

    public static final int i = 128;

    public static final int m = -2;

    static {
        System.out.println("MyParent2 static block");
    }
}
