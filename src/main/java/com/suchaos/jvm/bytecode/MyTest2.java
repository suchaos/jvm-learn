package com.suchaos.jvm.bytecode;

/**
 * 查看字节码，一行一行分析
 * <p>
 * 结合 jclasslib 一起看
 *
 * @author suchao
 * @date 2019/2/11
 */
public class MyTest2 {
    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public void setX(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);
        in = 20;
    }
}
