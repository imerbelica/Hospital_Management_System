
/*
 * This class is used to create mysql database connection.
 */

package com.hospital.management.system.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.stream.Stream;


public class DbConfig {

    private static Connection con = null;

    public static Connection getConnection()
    {
        String db = "hospital-management-db";
        String url = "jdbc:mysql://localhost:3333/hospital-management-db";
        String username = "root";
        String pwd = "3333";
        try {
            con = DriverManager.getConnection(url, username, pwd);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    private static DbConfig instance;

    public static DbConfig getInstance() {
        if (instance == null) {
            instance = new DbConfig();
        }
        return instance;
    }

    public int init(String... paths) {
        int modified = 0;

        for (String path : paths) {
            modified += executeSQLFile(path);
        }

        return modified;
    }

    public int executeSQLFile(String file) {
        int modified = 0;
        try (Connection connection = getConnection();
             BufferedReader br = new BufferedReader(new FileReader(file));) {
            String fileAsString = br.lines().reduce((acc, next) -> acc + next).orElse("");
            String[] queries = fileAsString.split(";");
            modified += Stream.of(queries).map(string -> {
                try (Statement statement = connection.createStatement();) {
                    return statement.executeUpdate(string);
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }).reduce(Integer::sum).orElse(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modified;
    }
}