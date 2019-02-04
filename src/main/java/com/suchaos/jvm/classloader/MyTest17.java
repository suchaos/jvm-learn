package com.suchaos.jvm.classloader;

/**
 * 对类不加载的演示
 * <p>
 * -XX:+TraceClassLoading
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.suchaos.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("classLoader: " + clazz.getClassLoader());

        // 如果注释掉该行，那么并不会实例化 MySample 对象，即 MySample 构造函数不会被调用
        // 因此不会实例化 MyCat 对象，即没有对 MyCat 进行主动使用，就不会初始化 MyCat Class，这里甚至都没有加载这个类
        Object object = clazz.newInstance();
    }
}
