package com.suchaos.jvm.gc;

/**
 * young gc demo
 *
 * -XX:NewSize=5242990
 * -XX:MaxNewSize=5242880
 * -XX:InitialHeapSize=10485760
 * -XX:MaxHeapSize=10485760
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=10485760
 * -XX:+UseParNewGC
 * -XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * -Xloggc:gc.log
 *
 * @author suchao
 * @date 2019/8/12
 */
public class YoungGCDemo {

    public static void main(String[] args) {
        byte[] array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = null;
        byte[] array2 = new byte[2 * 1024 * 1024];
    }
}
