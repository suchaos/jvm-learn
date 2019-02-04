package com.suchaos.jvm.classloader;

import java.io.File;

/**
 * 关于命名空间的重要说明：
 *
 * 子加载器所加载的类能能够访问父加载器所加载的类
 * 父加载器所加载的类无法访问到子加载器所加载的类
 *
 * 实验过程：
 * 1. 删除 MyCat, MySample 的 class,放到 D 盘对应目录中去， 不报错，结果都由 loader1 加载类
 * 2. 只删除 MySample, 结果 MySample 由 loader1 加载， MyCat 由系统类加载器加载
 * 3. 只删除 MyCat， 结果报错，MySample 由系统类加载器加载，此时接着用系统类加载器加载 MyCat，找不到，就报错了
 * 注意：因为加载一个类时用的是某一个类加载器，那么过程中需要加载的新类（比如那个类中引用的其他类）也会有这个加载器去加载
 *
 * 4. 然后在 MyCat 的构造函数中，增加 System.out.println(MySample.class);
 * 5. 只删除 MySample, 结果报错，因为 MySample 由 loader1 加载， MyCat 由系统类加载器加载， 但 MyCat 试图调用 MySample,
 * 父加载器所加载的类无法访问到子加载器所加载的类,所以报错
 *
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("D:" + File.separator);

        Class<?> clazz = loader1.loadClass("com.suchaos.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("classLoader: " + clazz.getClassLoader());

        Object object = clazz.newInstance();
    }
}
