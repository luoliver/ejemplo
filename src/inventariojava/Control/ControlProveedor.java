/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Control;

import inventariojava.Modelo.DAO.ProveedorDAO;
import inventariojava.Modelo.VO.ProveedorVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author luism
 */
public class ControlProveedor {
    Connection cnn;
    ProveedorDAO dao;
    
    public ControlProveedor(Connection cnn){
        this.cnn = cnn;
        this.dao = new ProveedorDAO(cnn);
    }
    
    public boolean insertar(ProveedorVO vo){
        if(vo.getNomempresa()== null || vo.getNomempresa().isEmpty()
                || vo.getWeb() == null || vo.getWeb().isEmpty()
                || vo.getContacto() == null || vo.getContacto().isEmpty()               
                || vo.getNomcontacto() == null || vo.getNomcontacto().isEmpty()
                || vo.getCiudad() == null || vo.getCiudad().isEmpty()
                || vo.getPais() == null || vo.getPais().isEmpty()
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
    
    public boolean modificar(ProveedorVO vo){
        if(vo.getNomempresa()== null || vo.getNomempresa().isEmpty()
                || vo.getWeb() == null || vo.getWeb().isEmpty()
                || vo.getContacto() == null || vo.getContacto().isEmpty()
                || vo.getNomcontacto() == null || vo.getNomcontacto().isEmpty()
                || vo.getCiudad() == null || vo.getCiudad().isEmpty()
                || vo.getPais() == null || vo.getPais().isEmpty()
                || vo.getIdproveedor() == 0){
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
    
    public boolean borrar(ProveedorVO vo){
        if(vo.getIdproveedor() == 0){
            return false;
        }else{
            try {
                dao.borrar(vo);
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
    
    public List<ProveedorVO> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
