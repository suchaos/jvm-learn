package com.suchaos.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 方法区产生内存溢出
 *
 * -XX:MaxMetaspaceSize=10m
 *
 * 使用 visualVM 直观观看 metaspace 使用情况
 *
 * @author suchao
 * @date 2019/4/30
 */
public class MyTest4 {

    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) ->
                    proxy.invokeSuper(obj, args1));
            System.out.println("hello , is running");
            enhancer.create();
        }
    }
}
