package com.suchaos.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单演示一下 java heap sapce oom
 *
 * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author suchao
 * @date 2019/4/27
 */
public class MyTest1 {

    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();
        while (true) {
            list.add(new MyTest1());
        }
    }
}
