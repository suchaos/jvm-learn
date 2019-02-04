package com.suchaos.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * 扩展类加载器的简单示例
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
