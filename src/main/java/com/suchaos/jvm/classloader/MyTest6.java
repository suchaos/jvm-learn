package com.suchaos.jvm.classloader;

/**
 * 准备阶段以及初始化阶段分析
 *
 * 在调用 Singleton.getInstance(); 之前，还没有进行初始化，进行了准备阶段
 * 此时： counter1 = 0， singleton = null, counter2 = 0, 都是默认值
 * 调用 Singleton.getInstance()，开始进行初始化阶段
 * 从上到下，
 * 1. 给静态变量赋值，counter1 = 1，
 * 2. 然后 singleton = new Singleton(), counter1++ -> 2, counter2++ -> 1
 * 3. counter = 0;
 *
 *
 * @author suchao
 * @date 2019/2/2
 */
public class MyTest6 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }
}

class Singleton {
    public static int counter1 = 1;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
