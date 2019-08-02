package com.suchaos.jvm.memory;

/**
 * 使用 Jconsole 检测死锁
 *
 * @author suchao
 * @date 2019/4/28
 */
public class MyTest3 {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void test1(){
        synchronized (lock1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do something test1");
            synchronized (lock2) {
                System.out.println("do something2 test1");
            }
        }
    }

    public void test2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do something test2");
            synchronized (lock1) {
                System.out.println("do something2 test2");
            }
        }
    }

    public static void main(String[] args) {
        MyTest3 myTest3 = new MyTest3();
        System.out.println("lock1: " + myTest3.lock1);
        System.out.println("lock2: " + myTest3.lock2);

        new Thread(myTest3::test1, "Thread A").start();
        new Thread(myTest3::test2, "Thread B").start();

    }
}
