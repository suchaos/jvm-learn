package com.suchaos.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用 jclasslib 查看 try catch finally 的字节码
 *
 * @author suchao
 * @date 2019/2/15
 */
public class MyTest3 {

    public int test() {
        try {
            InputStream is = new FileInputStream("text.txt");

            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();
            System.out.println("haah");
            return 1;
        } catch (FileNotFoundException e) {
            return 3;
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        } finally {
            System.out.println("finally block");
            return 2;
        }
        //return 5;
    }

    public static void test2() {
        try {
            InputStream is = new FileInputStream("text.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally block");
        }
    }

    public static void main(String[] args) {
        MyTest3 myTest3 = new MyTest3();
        System.out.println(myTest3.test());
    }

}
