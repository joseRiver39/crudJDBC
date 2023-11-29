package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.*;
import java.util.List;


public class TestMysqlJDBC {
    
    public static void main(String[] args) {
        
        UsuarioDAO usuarioDao = new UsuarioDAO();
//        
//        Usuario usuarioNuevo = new Usuario("juanCa", "xxx123");
//        usuarioDao.insertar(usuarioNuevo);
//        
//        Usuario usuarioNuevo2 = new Usuario("PedroRiver", "xxx124");
//        usuarioDao.insertar(usuarioNuevo2);
//        
//        
//        Usuario usuarioNuevo3 = new Usuario("CarlosPerez", "xxx125");
//        usuarioDao.insertar(usuarioNuevo3);
//        
//        Usuario usuarioModificar = new Usuario(2, "JoseAnt", "xxx321");
//        usuarioDao.actualizar(usuarioModificar);

          Usuario usuarioEliminar = new Usuario(3);
          usuarioDao.eliminar(usuarioEliminar);
          
          
          Usuario usuarioEliminar2= new Usuario(4);
          usuarioDao.eliminar(usuarioEliminar2);
        
        List<Usuario>usuarios = usuarioDao.seleccionar();
        for(Usuario usuario : usuarios){
            System.out.println("usuario =  "+ usuario);
        }
        
        
        
        
        
        
        
       
 }
}
        
        
    
    

