package com.suchaos.jvm.bytecode;

/**
 * 开始学习 bytecode
 * <p>
 * E:\learn\jvm_lecture\target\classes>javap -c com.suchaos.jvm.bytecode.MyTest1
 *
 * @author suchao
 * @date 2019/2/8
 */
public class MyTest1 {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
