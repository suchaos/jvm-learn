package com.suchaos.jvm.gc;

/*
*
 * CMS 的各阶段
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRation=8
 * -XX:+UseConcMarkSweepGC
 * -XX:+PrintCommandLineFlags
 * //-XX:MetaspaceSize=256m
 * //-XX:MaxMetaspaceSize=256m
 * //-XX:CMSInitiatingOccupancyFraction=96
 *
 * @author suchao
 * @date 2019/8/4
*/
public class CMSTest {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[4 * MB];
        System.out.println("1-------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] allocation2 = new byte[4 * MB];
        System.out.println("2-------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] allocation3 = new byte[4 * MB];
        System.out.println("3-------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        byte[] allocation4 = new byte[2 * MB];
//        System.out.println("4-------------------------------------");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
