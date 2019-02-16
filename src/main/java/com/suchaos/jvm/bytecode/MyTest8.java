package com.suchaos.jvm.bytecode;

import java.util.Date;

/**
 * 虚方法表与动态分派机制
 *
 * @author suchao
 * @date 2019/2/16
 */
public class MyTest8 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal {
    public void test(String string) {
        System.out.println("animal str");
    }

    public void test(Date date) {
        System.out.println("animal date");
    }
}

class Dog extends Animal {
    @Override
    public void test(String string) {
        System.out.println("dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("dog date");
    }
}
