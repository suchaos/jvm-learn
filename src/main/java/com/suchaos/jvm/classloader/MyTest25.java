package com.suchaos.jvm.classloader;

import java.sql.Driver;
import java.util.ServiceLoader;

/**
 * 线程上下文类加载器的一般使用模型（获取 -- 使用 -- 还原）
 *
 * <blockquote><pre>
 * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * try {
 *     Thread.currentThread().setContextClassLoader(targetTccl);
 *     myMethod();
 * } finallly {
 *     Thread.currentThread().setContextClassLoader(classLoader);
 * }
 * </pre></blockquote>
 * myMethod里面调用了 Thread.currentThread().getContextClassLoader()，
 * 获取当前线程的上下文类加载器做某些事情。
 * <p>
 * 如果一个类有类加载器A加载，那么这个类的依赖类也是有相同的类加载器加载的
 * （如果该类之前没有被加载过的话）
 * <p>
 * ContextClassLoader的作用就是为了破坏 Java 的类加载委托机制。
 * <p>
 * 当高层提供了统一的接口让底层去实现，同时又要在高层加载（或实例化）底层的类时，就必须要通过线程上下
 * 文类加载器来帮助高层的 ClassLoader 找到并帮助加载该类。
 *
 * @author suchao
 * @date 2019/2/5
 */
public class MyTest25 {
    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);

        for (Driver driver : loader) {
            System.out.println("driver: " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }

        System.out.println("当前线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类" +
                "加载器：" + ServiceLoader.class.getClassLoader());
    }
}
