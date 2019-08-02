package com.suchaos.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 用作演示动态代理的客户端
 *
 * @author suchao
 * @date 2019/2/18
 */
public class Client {
    public static void main(String[] args) {

        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();

        Subject subject = (Subject) Proxy.
                newProxyInstance(cls.getClassLoader(), new Class<?>[]{Subject.class}, ds);

        subject.request();

        System.out.println(subject.toString());

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
    }
}
