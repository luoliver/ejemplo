/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Modelo.DAO;

import inventariojava.Modelo.VO.UsuarioVO;
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
public class UsuarioDAO {
    Connection cnn;
    
    public UsuarioDAO(Connection cnn){
        this.cnn = cnn;
    }
    
    public void insertar(UsuarioVO vo) throws SQLException{
        PreparedStatement sentencia;
        sentencia = cnn.prepareStatement("INSERT INTO usuarios (usuario,contrasena,nombre,email,fechanacimiento,rol)"
                +"VALUES (?,?,?,?,?,?)");
        sentencia.setString(1, vo.getUsuario());
        sentencia.setString(2, vo.getContrasena());
        sentencia.setString(3, vo.getNombre());
        sentencia.setString(4, vo.getEmail());
        sentencia.setDate(5, new java.sql.Date(vo.getFechanacimiento().getTime()));
        sentencia.setString(6, vo.getRol());
        sentencia.executeUpdate();
    }
    
    public void Borrar(UsuarioVO vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                "DELETE usuarios"+"WHERE idusuario = ?");
        sentencia.setInt(1, vo.getIdusuario());
        sentencia.executeUpdate();
    }
    
    public void modificar(UsuarioVO vo) throws SQLException{
        PreparedStatement sentencia=
                cnn.prepareStatement(
                        "UPDATE usuarios SET usuario = ?, contrasena = ?, nombre =?,email=?,fechanacimiento=?,rol=?"
                        + "WHERE idusuario = ?");
        sentencia.setString(1, vo.getUsuario());
        sentencia.setString(2, vo.getContrasena());
        sentencia.setString(3, vo.getNombre());
        sentencia.setString(4, vo.getEmail());
        sentencia.setDate(5, new java.sql.Date(vo.getFechanacimiento().getTime()));
        sentencia.setString(6, vo.getRol());
        sentencia.setInt(7, vo.getIdusuario());
        sentencia.executeUpdate();        
    }
    public List<UsuarioVO> consultar() throws SQLException{
        List<UsuarioVO> listaContactos = new ArrayList<>();
        
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM usuarios");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            UsuarioVO voTemp = new UsuarioVO();
            voTemp.setIdusuario(resultado.getInt("idusuario"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setContrasena(resultado.getString("contrasena"));
            voTemp.setUsuario(resultado.getString("usuario"));
            voTemp.setEmail(resultado.getString("email"));
            voTemp.setFechanacimiento(resultado.getDate("fechanacimiento"));
            voTemp.setRol(resultado.getString("rol"));
            listaContactos.add(voTemp);            
        }
        if(listaContactos.size() > 0){
            return listaContactos;
        }else{
            return null;
        }
        
    }
}
