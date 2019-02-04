package com.suchaos.jvm.classloader;

import sun.misc.Launcher;

/**
 * 可以命令行运行，修改 系统属性
 * java -Dsun.boot.class.path=.\ com.suchaos.jvm.classloader.MyTest23
 * java -Djava.ext.dirs=.\ com.suchaos.jvm.classloader.MyTest23
 * 但是扩展类加载器（Extension ClassLoader）加载的必须是 jar 包
 *
 * 在 Oracle 的 Hotspot 实现中，系统属性 sun.boot.class.path 如果修改错了，则运行会出错
 * 注意：这是 Java8 环境, 如果是 Java10， 结果会不一样
 * Error occurred during initialization of VM
 * java/lang/NoClassDefFoundError: java/lang/Object
 *
 * 内建于 JVM 中的启动类加载器会加载 java.lang.ClassLoaDER 以及其他的 Java 平台类，
 * 当 JVM 启动时，一块特殊的机器码会运行，他会加载扩展类加载器与系统类加载器，
 * 这块特殊的机器码叫做启动类加载器（Bootstrap）
 *
 * 启动类加载器并不是 Java 类，而其他的加载器则都是 Java 类，
 * 启动类加载器是特定于平台的机器指令，他负责开启整个加载过程。
 *
 * 所有类加载器（除了启动类加载器）都被实现为 Java 类，不过，总归要有一个组件来加载第一个 Java 类加载器
 * 从而让整个加载过程能够顺利进行下去，加载第一个纯 Java 类加载器就是启动类加载器的职责。
 *
 * 启动类加载器还会负责加载供 JRE 正常运行所需要的基本组件，这包括 java.util, java.lang 包中的类等。
 *
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyTest23 {
    public static void main(String[] args) {
        // 这三个路径在 sun.misc.Launcher 源代码中都能找到
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(ClassLoader.class.getClassLoader());
        // 扩展类加载器与系统类加载器也是由启动类加载器加载的
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("---------------------");

        // java -Djava.system.class.loader=com.suchaos.jvm.classloader.MyTest16 com.suchaos.jvm.classloader.MyTest23
        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
