package com.suchaos.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * 查看 GC 日志
 * <p>
 * VM:
 * -verbose:gc
 * -Xms2000M
 * -Xmx2000M
 * -Xmn1000M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 *
 * @author suchao
 * @date 2019/8/2
 */
public class TestAllocation {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * MB];
        byte[] allocation2 = new byte[2 * MB];
        byte[] allocation3 = new byte[3 * MB];
        byte[] allocation4 = new byte[3 * MB];
    }

    private static void sleep(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
