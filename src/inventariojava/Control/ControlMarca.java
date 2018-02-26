/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Control;

import inventariojava.Modelo.DAO.MarcasDAO;
import inventariojava.Modelo.VO.MarcasVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author luism
 */
public class ControlMarca {
     Connection cnn;
    MarcasDAO dao;
    
    public ControlMarca(Connection cnn){
        this.cnn = cnn;
        this.dao = new MarcasDAO(cnn);
    }
    
    public boolean insertar(MarcasVO vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
           ||  vo.getDetalle()== null || vo.getDetalle().isEmpty()    
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
    
    public boolean modificar(MarcasVO vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
           ||  vo.getDetalle()== null || vo.getDetalle().isEmpty() 
                || vo.getIdmarca() == 0){
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
    
    public boolean borrar(MarcasVO vo){
        if(vo.getIdmarca() == 0){
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
    
    public List<MarcasVO> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }        
    }
}
