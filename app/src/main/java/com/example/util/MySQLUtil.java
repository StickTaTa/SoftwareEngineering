package com.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLUtil {

    static Connection con = null;
    static Properties ps = new Properties();

    static {
        InputStream in = MySQLUtil.class.getClassLoader().getResourceAsStream("./data.properties");

        try {
            ps.load(in);
            String driver = ps.getProperty("driver");
            String url = ps.getProperty("url");
            String userName = ps.getProperty("username");
            String pwd = ps.getProperty("pwd");
            Class.forName(driver);

            con = DriverManager.getConnection(url, userName, pwd);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 建立连接的方法
    public static Connection getConnection() {
        return con;
    }

    // 关闭资源的方法

    public static void closeRes(ResultSet rs, PreparedStatement ps, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
