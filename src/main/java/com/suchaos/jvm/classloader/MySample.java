package com.suchaos.jvm.classloader;

/**
 * MySample
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MySample {
    public MySample() {
        System.out.println("invoked MySample constructor and is loaded by " + this.getClass().getClassLoader());
        new MyCat();
    }
}
