package com.suchaos.jvm.classloader;

import java.util.Properties;
import java.util.Set;

/**
 * 查看具体不同的类加载器所加载类的路径
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyTest18 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
