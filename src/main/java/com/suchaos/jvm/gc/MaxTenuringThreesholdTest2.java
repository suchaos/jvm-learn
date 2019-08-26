package com.suchaos.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * 演示动态年龄规则进入老年代的过程
 * <p>
 * VM:
 * -XX:NewSize=10485760
 * -XX:MaxNewSize=10485760
 * -XX:InitialHeapSize=20971520
 * -XX:MaxHeapSize=20971520
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=10485760
 * -XX:+PrintGCDetails
 * -XX:MaxTenuringThreshold=15
 * -XX:+UseParNewGC
 * -XX:+UseConcMarkSweepGC
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintTenuringDistribution
 * <p>
 * 新生代设置为 10MB, 其中 Eden 8MB，每个 survivor 1MB
 * 老年代 10MB，大对象必须超过 10MB 才会直接进入老年代
 *
 * @author suchao
 * @date 2019/8/2
 */
public class MaxTenuringThreesholdTest2 {

    public static void main(String[] args) throws InterruptedException {
        byte[] array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = new byte[2 * 1024 * 1024];
        array1 = null;

        byte[] array2 = new byte[128 * 1024];

        byte[] array3 = new byte[2 * 1024 * 1024];

        array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[2 * 1024 * 1024];
        array3 = new byte[128 * 1024];
        array3 = null;

        TimeUnit.SECONDS.sleep(1);

        byte[] array4 = new byte[2 * 1024 * 1024];
    }
}
