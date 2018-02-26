/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luism
 */
public class Conexion {
    public static Connection getConexion() throws ClassNotFoundException, SQLException{
        String servidor = "localhost";
        String nombreDB = "inventariojaVva";
        String usuario = "Laions";
        String clave = "nomelase";
        String puerto="3306";
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection cnn = DriverManager.getConnection("jdbc:mysql://"+servidor+":"+puerto+"/"+nombreDB,usuario,clave);
        cnn.setAutoCommit(false);
        return cnn;
    }
    
    public static void cerrarConexion(Connection cnn) throws SQLException{
        cnn.commit();
        cnn.close();
    }
    
    public static void cancelarTrans(Connection cnn) throws SQLException{
        cnn.rollback();
        cnn.close();
    }
}
