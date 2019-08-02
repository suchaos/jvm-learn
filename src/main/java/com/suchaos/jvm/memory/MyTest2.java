package com.suchaos.jvm.memory;

/**
 * 演示 虚拟机栈溢出
 *
 * @author suchao
 * @date 2019/4/28
 */
public class MyTest2 {

    private int length;

    public int getLength() {
        return length;
    }

    public void test() throws InterruptedException {
        Thread.sleep(300);
        this.length++;
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();

        try {
            myTest2.test();
        } catch (Throwable ex) {
            System.out.println(myTest2.getLength());
            ex.printStackTrace();
        }
    }

}
