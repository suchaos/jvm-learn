package com.suchaos.jvm.classloader;

/**
 * current class loader：当前类加载器
 * <p>
 * 每个类都会使用自己的类加载器（即加载自身的类加载器）来去加载其他类（指的是所依赖的类），
 * 如果 ClassX 引用了 ClassY，那么 ClassX 的类加载器就会去加载 ClassY（前提是 ClassY 尚未被加载）
 * <p>
 * context class loader：线程上下文类加载器
 * 线程上下文类加载器（context class loader）是从JDK 1.2开始引入的。类java.lang.Thread中的方法
 * getContextClassLoader() 和 setContextClassLoader(ClassLoader cl) 用来获取和设置线程的上下文类加载器。
 * <p>
 * 如果没有通过 setContextClassLoader(ClassLoader cl) 方法进行设置的话，线程将继承其父线程的上下文类加载器。
 * Java 应用运行的初始线程的上下文类加载器是系统类加载器。在线程中运行的代码可以通过此类加载器来加载类和资源。
 * <p>
 * 线程上下文类加载器的重要性
 * <p>
 * SPI（Service Provider Interface）
 * <p>
 * 父 ClassLoader 可以使用当前线程 Thread.getContextClassLoader()所指定的 classloader 加载的类。
 * 这就改变了父 Classloader 不能使用子Classloader或是其他没有直接父子关系的Classloader加载的类的情况，
 * 即改变了双亲委托模型。
 * <p>
 * 线程上下文类加载器就是当前线程的 Current Classloader。
 * <p>
 * 在双亲委托模型下，类加载是由下至上的，即下层的类加载器会委托上层进行加载。
 * 但是对于 SPIl来说，有些接口是 Java 核心库提供的，而 Java 核心库是由启动类加载器加载的，
 * 而这些接口的实现却来自于不同的 jar 包（厂商提供）， Java 的启动类加载器是不会加载其他来源的 jar 包，
 * 这样传统的双亲委托模型就无法满足 SPI的要求。而通过给当前线程设置上下文类加载器，
 * 就可以由设置的上下文类加载器来实现对于接口实现类的加载。
 *
 * @author suchao
 * @date 2019/2/5
 */
public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}
