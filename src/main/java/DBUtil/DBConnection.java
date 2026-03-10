package DBUtil;

import java.sql.*;

public class DBConnection {
    private static String url="jdbc:postgresql://localhost:5432/emp";
    private static String user="postgres";
    private static String password="1234";
    public static Connection getConnection() {
        Connection con=null;
        try {
            // step1:Load postgreSQL Driver
            Class.forName("org.postgresql.Driver");
            // step2:create the connection
            con=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
