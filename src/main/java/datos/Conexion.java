package datos;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/sga?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "jose401";
    
    public static Connection getConnection() throws SQLException{
      return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    
    public static void  close(ResultSet rs) throws SQLException{
    rs.close();
    }
    public static void  close(Statement smtm) throws SQLException{
    smtm.close();
    }
    public static void  close(PreparedStatement psmtm) throws SQLException{
    psmtm.close();
    }
    public static void  close(Connection conn) throws SQLException{
    conn.close();
    }
}
