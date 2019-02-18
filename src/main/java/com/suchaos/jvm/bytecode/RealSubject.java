package com.suchaos.jvm.bytecode;

/**
 * 用作演示动态代理
 *
 * @author suchao
 * @date 2019/2/18
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("From real subject");
    }
}
