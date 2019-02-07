package com.suchaos.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * context class loader
 *
 * 自己跟进去方法，看看 JDBC 加载类的过程
 *
 * @author suchao
 * @date 2019/2/6
 */
public class MyTest27 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
    }
}
