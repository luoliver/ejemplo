/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Modelo.DAO;

import inventariojava.Modelo.VO.FacturaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luism
 */
public class FacturaDAO {
     Connection cnn;
    
    public FacturaDAO(Connection cnn){
        this.cnn = cnn;
    }
    
    public void insertar(FacturaVO vo) throws SQLException {
        PreparedStatement sentencia;
        sentencia = cnn.prepareStatement("INSERT INTO factura (nombre,fecha,empleado,producto,cantidad)"
                +"VALUES (?,?,?,?,?)");
        sentencia.setString(1, vo.getNombre());
        sentencia.setDate(2, new java.sql.Date(vo.getFecha().getTime()));
        sentencia.setInt(3, vo.getEmpleado()); 
        sentencia.setInt(4, vo.getProducto());
        sentencia.setInt(5, vo.getCantidad());
        sentencia.executeUpdate();
        
    }
    
    public void Borrar() {
        
    }
    
    public void modificar() {
            
    }

    
    
}
