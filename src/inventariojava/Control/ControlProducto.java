/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Control;

import inventariojava.Modelo.DAO.ProductoDAO;
import inventariojava.Modelo.VO.ProductosVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author luism
 */
public class ControlProducto {
    Connection cnn;
    ProductoDAO dao;
    
    public ControlProducto(Connection cnn){
        this.cnn = cnn;
        this.dao = new ProductoDAO(cnn);
    }
    
    public boolean insertar(ProductosVO vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getMarca() == 0
                || vo.getCosto() == 0
                || vo.getFechavencimineto() == null
                || vo.getPrecio() == 0
                || vo.getCantidad() == 0
                || vo.getProveedor() == 0
                ){
            return false;
        }else{
            try {
                dao.insertar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        
    }
    
    public boolean modificar(ProductosVO vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getMarca() == 0
                || vo.getCosto() == 0
                || vo.getFechavencimineto() == null
                || vo.getPrecio() == 0
                || vo.getCantidad() == 0
                || vo.getProveedor() == 0
                || vo.getIdproducto() == 0){
            return false;
        }else{
            try {
                dao.modificar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        
    }
    
    public boolean borrar(ProductosVO vo){
        if(vo.getIdproducto() == 0){
            return false;
        }else{
            try {
                dao.Borrar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
    
    public List<ProductosVO> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }    
}
