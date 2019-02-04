package com.suchaos.jvm.classloader;

import java.io.*;

/**
 * 自定义一个类加载器
 *
 * -XX:+TraceClassUnloading
 * 可以看到类的卸载
 * [Unloading class com.suchaos.jvm.classloader.MyTest1 0x0000000100061028]
 *
 * @author suchao
 * @date 2019/2/3
 */
public class MyTest16 extends ClassLoader {
    private String classLoaderName;

    private String path;

    public MyTest16(String classLoaderName) {
        super(); // 将系统类加载器当作该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent); // 显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) {
        System.out.println("use customer classloader " + classLoaderName + " load " + className);
        byte[] data = this.loadClassData(className);
        assert data != null;
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        className = className.replace(".", File.separator);
        String fileExtension = ".class";

        try (InputStream is = new FileInputStream(new File(path + className + fileExtension));
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void test(ClassLoader classLoader) throws Exception {

        Class<?> clazz = classLoader.loadClass("com.suchaos.jvm.classloader.MyTest1");
        //Class<?> clazz = Class.forName("com.suchaos.jvm.classloader.MyTest1", true, classLoader);
        System.out.println(clazz.getClassLoader());
        Object instance = clazz.newInstance();
        System.out.println(instance);
    }

    public static void main(String[] args) throws Exception {
        MyTest16 classLoader1 = new MyTest16("Loader1");
        // 将 target 中的 MyTest1.class 移到 d盘的com/suchaos/jvm/classloader/下
        classLoader1.setPath("D:" + File.separator);
        Class<?> clazz1 = classLoader1.loadClass("com.suchaos.jvm.classloader.MyTest1");
        System.out.println(clazz1.getClassLoader());
        System.out.println(clazz1.hashCode());
        Object instance1 = clazz1.newInstance();
        System.out.println(instance1);
        System.out.println("-------------------------");
        /*MyTest16 classLoader2 = new MyTest16(classLoader1, "Loader2");
        classLoader2.setPath("D:" + File.separator);
        Class<?> clazz2 = classLoader2.loadClass("com.suchaos.jvm.classloader.MyTest1");
        System.out.println(clazz2.getClassLoader());
        System.out.println(clazz2.hashCode());
        Object instance2 = clazz2.newInstance();
        System.out.println(instance2);*/
        System.out.println("------------------------------");
        classLoader1 = null;
        clazz1 = null;
        instance1 = null;
        System.gc();
        System.out.println("-------------------------------------");
        classLoader1 = new MyTest16("Loader1");
        classLoader1.setPath("D:" + File.separator);
        clazz1 = classLoader1.loadClass("com.suchaos.jvm.classloader.MyTest1");
        instance1 = clazz1.newInstance();
    }
}
