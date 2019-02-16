package com.suchaos.jvm.bytecode;

/**
 * 方法调用
 * <p>
 * 分析字节码实现（使用 jclasslib 插件）
 *
 *  invokestatic #methodref
 *
 * @author suchao
 * @date 2019/2/16
 */
public class MyTest5 {
    public static void test() {
        System.out.println("test invoke");
    }

    public static void main(String[] args) {
        test();
        MySon son = new MySon();
        son.pmethod();
        son.smd1();
    }
}

class Parent {
    public void pmethod() {
        System.out.println("parent pmethod");
    }
}

class MySon extends Parent {
    private void smethod() {
        System.out.println("son s private method");
    }

    public void smd1() {
        this.smethod();
        this.pubme();
    }

    public void pubme() {
        System.out.println("son s public method");
    }
}

