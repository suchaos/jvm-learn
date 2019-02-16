package com.suchaos.jvm.bytecode;

/**
 * 方法的静态分配
 * <p>
 * <code>Grandpa g1 = new Father();</code>
 * <p>
 * 以上代码， g1 的静态类型是 Grandpa， 而 g1 的实际类型（真正指向的类型）是 Father
 * <p>
 * 我们可以得到一个结论：变量的静态类型是不会发生变化的，而变量的实际类型是可以发生变化的（多态的一种体现）
 * 实际类型是在运行期方可确定
 * <p>
 * 方法重载，是一种静态的行为，编译器就已经确定了，可以查看字节码确定
 *
 * @author suchao
 * @date 2019/2/16
 */
public class MyTest6 {


    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest6 myTest6 = new MyTest6();
        myTest6.test(g1);
        myTest6.test(g2);
    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}
