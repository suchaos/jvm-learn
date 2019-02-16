package com.suchaos.jvm.bytecode;

/**
 * 方法的动态分配涉及到一个重要概念：方法接收者（也就是看到底是谁调用这个方法的）
 *
 * `invokevirtual`字节码指令的多态查找流程：
 *
 * 1. 找到操作数栈顶的第一个元素它所指向的实际类型
 * 2. 如果在此类型中找到了和常量池中方法名称和方法描述符一致的方法，并且访问权限也校验通过了，就返回这个方法的直接引用，然后调用这个方法，流程就结束了
 * 3. 如果上一步没找到，就沿着继承体系从下往上查找，在某个层次找到就调用
 * 4. 一直没找到，就抛异常了
 *
 * @author suchao
 * @date 2019/2/16
 */
public class MyTest7 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();
    }
}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}
