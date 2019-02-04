package com.suchaos.jvm.classloader;

/**
 * MyCat
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyCat {
    public MyCat() {
        System.out.println("invoked MyCat() constructor and is loaded by " + this.getClass().getClassLoader());
        System.out.println(MySample.class);
    }
}
