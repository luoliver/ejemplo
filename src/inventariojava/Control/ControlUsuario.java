/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Control;

import inventariojava.Modelo.DAO.UsuarioDAO;
import inventariojava.Modelo.VO.UsuarioVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author luism
 */
public class ControlUsuario {
    Connection cnn;
    UsuarioDAO dao;
    
    public ControlUsuario(Connection cnn){
        this.cnn = cnn;
        this.dao = new UsuarioDAO(cnn);
    }
    
    public boolean insertar(UsuarioVO vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getUsuario() == null || vo.getUsuario().isEmpty()
                || vo.getContrasena() == null || vo.getContrasena().isEmpty()
                || vo.getFechanacimiento() == null
                || vo.getEmail() == null || vo.getEmail().isEmpty()
                || vo.getRol() == null || vo.getRol().isEmpty()){
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
    
    public boolean modificar(UsuarioVO vo){
        if(vo.getNombre()== null || vo.getNombre().isEmpty()
                || vo.getUsuario() == null || vo.getUsuario().isEmpty()
                || vo.getContrasena() == null || vo.getContrasena().isEmpty()
                || vo.getFechanacimiento() == null
                || vo.getEmail() == null || vo.getEmail().isEmpty()
                || vo.getRol() == null || vo.getRol().isEmpty()
                || vo.getIdusuario() == 0){
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
    
    public boolean borrar(UsuarioVO vo){
        if(vo.getIdusuario() == 0){
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
    
    public List<UsuarioVO> consultar(){
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;}
        
    }
}
