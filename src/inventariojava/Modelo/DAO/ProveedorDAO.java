/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Modelo.DAO;

import inventariojava.Modelo.VO.ProveedorVO;
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
public class ProveedorDAO {
    Connection cnn;
    
    public ProveedorDAO(Connection cnn){
        this.cnn = cnn;
    }
    
    public void insertar(ProveedorVO vo ) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement("INSERT INTO proveedor (nomempresa,web,contacto,nomcontacto,ciudad,pais)"
                +"VALUES (?,?,?,?,?,?)");
        sentencia.setString(1, vo.getNomempresa());
        sentencia.setString(2, vo.getWeb());
        sentencia.setString(3, vo.getContacto());
        sentencia.setString(4, vo.getNomcontacto());
        sentencia.setString(5, vo.getCiudad());
        sentencia.setString(6,vo.getPais());
        sentencia.executeUpdate();
    }
    
    public void borrar(ProveedorVO vo) throws SQLException{
        PreparedStatement sentencia =
                cnn.prepareStatement("DELETE proveedor" + "WHERE idproveedor = ?");
        sentencia.setInt(1, vo.getIdproveedor());
        sentencia.executeUpdate();
    }
    
    public void modificar(ProveedorVO vo) throws SQLException{
        PreparedStatement sentencia =
                cnn.prepareStatement
                    ("UPDATE proveedor SET nomempresa = ?,web=?,contacto=?,nomcontacto=?,ciudad=?,pais=?"
                            +"WHERE idproveedor =?");
        sentencia.setString(1, vo.getNomempresa());
        sentencia.setString(2,vo.getWeb());
        sentencia.setString(3, vo.getContacto());
        sentencia.setString(4,vo.getNomcontacto());
        sentencia.setString(5,vo.getCiudad());
        sentencia.setString(6,vo.getPais());
        sentencia.setInt(8, vo.getIdproveedor());
        
    }
    public List<ProveedorVO> consultar() throws SQLException{
        List<ProveedorVO> listaContactos = new ArrayList<>();
        
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM proveedor");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            ProveedorVO voTemp = new ProveedorVO();
            voTemp.setIdproveedor(resultado.getInt("idproveedor"));
            voTemp.setNomempresa(resultado.getString("nomempresa"));
            voTemp.setWeb(resultado.getString("web"));
            voTemp.setContacto(resultado.getString("contacto"));
            voTemp.setNomcontacto(resultado.getString("nomcontacto"));
            voTemp.setCiudad(resultado.getString("ciudad"));
            voTemp.setPais(resultado.getString("pais"));
            listaContactos.add(voTemp);
        }
        if(listaContactos.size() > 0){
            return listaContactos;
        }else{
            return null;
        }
        
    }
}
