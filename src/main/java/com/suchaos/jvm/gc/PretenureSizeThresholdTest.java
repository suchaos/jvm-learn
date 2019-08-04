package com.suchaos.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * PretenureSizeThreshold
 * <p>
 * VM:
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=4194304
 * -XX:+UseConcMarkSweepGC
 *
 * @author suchao
 * @date 2019/8/2
 */
public class PretenureSizeThresholdTest {
    private static final int MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[8 * MB];
    }
}
