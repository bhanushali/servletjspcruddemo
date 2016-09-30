
package com.niit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {    
    private static Connection con = null;
    private final static String JDBC_URL = "jdbc:h2:tcp://localhost/~/jdbcdemo";
    private final static String JDBC_USERNAME = "sa";
    private final static String JDBC_PASSWORD = "";

    public static Connection getConnection() {    
        if(con != null) {
            return con;
        }
        
        try {        
            Class.forName("org.h2.Driver");            
            con = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            return con;
        }
        catch(ClassNotFoundException ex) {
            System.out.println("No drive class found: " + ex.getMessage());
        }
        catch(SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        }
        return null;            
    }
    
}
