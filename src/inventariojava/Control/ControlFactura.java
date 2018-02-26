/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Control;

import inventariojava.Modelo.DAO.FacturaDAO;
import inventariojava.Modelo.DAO.ProductoDAO;
import inventariojava.Modelo.VO.FacturaVO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ControlFactura {
    Connection cnn;
    FacturaDAO dao;
    
    public ControlFactura(Connection cnn){
        this.cnn = cnn;
        this.dao = new FacturaDAO(cnn);
    }
    public boolean insertar(FacturaVO vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getEmpleado() == 0
                || vo.getFecha() == null
                || vo.getProducto() == 0 
                || vo.getCantidad() == 0 
                ){
            return false;
        }else{
            try {
                dao.insertar(vo);
                ProductoDAO daoP= new ProductoDAO(cnn);
                daoP.descontar(vo.getProducto(),vo.getCantidad());
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }            
        }
        
    }
}
