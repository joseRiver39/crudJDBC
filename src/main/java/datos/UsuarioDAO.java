package datos;

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    
    private static final String SQL_SELECT ="SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password  = ? WHERE id_usuario = ?" ;
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
     
     
    public List<Usuario> seleccionar(){
    Connection conn = null;
    PreparedStatement  stmt = null;
    ResultSet rs = null;
    Usuario usuarioLis = null;
    List<Usuario> usuarios = new ArrayList<>();
    
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
               int idUsuario = rs.getInt("id_usuario");
               String usuario = rs.getString("usuario");
               String password = rs.getString("password");
                usuarioLis = new Usuario(idUsuario, usuario, password);
                
                usuarios.add(usuarioLis);
            }
        } catch (SQLException ex) {
               ex.printStackTrace(System.out);
        }
        
        finally{
        try {
           close(rs);
           close(stmt);
           close(conn);
        } catch (SQLException ex) {
              ex.printStackTrace(System.out);
        }
        }
      return usuarios;
    }
    
    public int insertar(Usuario  usuario){
    
      Connection conn = null;
      PreparedStatement stmt = null;
      int registro = 0;
      
        try {
            conn  = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1,usuario.getUsuario());
            stmt.setString(2,usuario.getPassword());
            registro = stmt.executeUpdate();
            
        } catch (SQLException ex) {

           ex.printStackTrace(System.out);
        }
        finally{
          try {
              close(stmt);
              close(conn);
          } catch (SQLException ex) {
               ex.printStackTrace(System.out);
          }
            
        
        }
        return registro;
    }

    public int actualizar(Usuario  usuario){
    
      Connection conn = null;
      PreparedStatement stmt = null;
      int registro = 0;
      
        try {
            conn  = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,usuario.getUsuario());
            stmt.setString(2,usuario.getPassword());
            stmt.setInt(3,usuario.getIdUsuario());
            registro = stmt.executeUpdate();
            
        } catch (SQLException ex) {

           ex.printStackTrace(System.out);
        }
        finally{
          try {
              close(stmt);
              close(conn);
          } catch (SQLException ex) {
               ex.printStackTrace(System.out);
          }
            
        
        }
        return registro;
    }
    public int eliminar(Usuario  usuario){
    
      Connection conn = null;
      PreparedStatement stmt = null;
      int registro = 0;
      
        try {
            conn  = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());            
            registro = stmt.executeUpdate();
            
        } catch (SQLException ex) {

           ex.printStackTrace(System.out);
        }
        finally{
          try {
              close(stmt);
              close(conn);
          } catch (SQLException ex) {
               ex.printStackTrace(System.out);
          }
            
        
        }
        return registro;
    }


}

