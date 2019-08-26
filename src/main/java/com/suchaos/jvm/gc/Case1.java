package com.suchaos.jvm.gc;

import java.util.concurrent.TimeUnit;

/**
 * TODO description class
 *
 * @author suchao
 * @date 2019/8/25
 */
public class Case1 {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        while (true) {
            loadData();
        }
    }

    private static void loadData() throws InterruptedException {
        byte[] data = null;
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;

        TimeUnit.SECONDS.sleep(1);
    }
}
