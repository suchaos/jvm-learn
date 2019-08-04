package com.suchaos.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * PrintSafepointStatistics
 * <p>
 * VM:
 * -verbose:gc
 * -Xms200M
 * -Xmx200M
 * -Xmn50M
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintCommandLineFlags
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:MaxTenuringThreshold=3
 * -XX:+PrintSafepointStatistics
 * -XX:PrintSafepointStatisticsCount=1
 *
 *
 * @author suchao
 * @date 2019/8/2
 */
public class MaxTenuringThreesholdTest {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[MB / 2];
        byte[] allocation2 = new byte[MB / 2];

        gc();
        sleep(1000, TimeUnit.MILLISECONDS);
        System.out.println("111111111111111111111111");

        gc();
        sleep(1000, TimeUnit.MILLISECONDS);
        System.out.println("2222222222222222222222222");

        gc();
        sleep(1000, TimeUnit.MILLISECONDS);
        System.out.println("3333333333333333333333333");

        gc();
        sleep(1000, TimeUnit.MILLISECONDS);
        System.out.println("444444444444444444444444");

        byte[] bytes1 = new byte[MB];
        byte[] bytes2 = new byte[MB];
        byte[] bytes3 = new byte[MB];

        gc();
        sleep(1000, TimeUnit.MILLISECONDS);
        System.out.println("55555555555555555555555");

        gc();
        sleep(1000, TimeUnit.MILLISECONDS);
        System.out.println("66666666666666666666666666");

    }

    private static void gc() {
        for (int i = 0; i < 40; i++) {
            byte[] bytes = new byte[MB];
        }
    }

    private static void sleep(int timeout, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
