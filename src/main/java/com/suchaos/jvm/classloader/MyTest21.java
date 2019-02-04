package com.suchaos.jvm.classloader;

import java.io.File;
import java.lang.reflect.Method;

/**
 * 在运行期，一个 Java 类是由该类的完全限定名（binary name）和
 * 用于加载该类的定义类加载器（defining loader）所共同决定的。
 *
 * 如果同样名字（即相同的完全限定名）的类是由两个不同的加载器（可以是同一个类的两个实例对象）所加载的，
 * 那么这些类就是不同的，即便 .class 文件的字节码完全一样，并且从相同的位置加载亦如此。
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyTest21 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16(
                "loader2");

        loader1.setPath("D:" + File.separator);
        loader2.setPath("D:" + File.separator);

        Class<?> clazz1 = loader1.loadClass("com.suchaos.jvm.classloader.MyPerson");
        System.out.println("clazz1 class is loaded by: " + clazz1.getClassLoader());
        Class<?> clazz2 = loader2.loadClass("com.suchaos.jvm.classloader.MyPerson");
        System.out.println("clazz2 class is loaded by: " + clazz2.getClassLoader());

        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
