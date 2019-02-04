package com.suchaos.jvm.classloader;

/**
 * MyPerson 与 MyTest20 一起使用
 *
 * @author suchao
 * @date 2019/2/4
 */
public class MyPerson {
    private MyPerson myPerson;

    public void setMyPerson(Object object) {
        this.myPerson = (MyPerson) object;
    }
}
