/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Modelo.DAO;

import inventariojava.Modelo.VO.MarcasVO;
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
public class MarcasDAO {
     Connection cnn;
    
    public MarcasDAO(Connection cnn){
        this.cnn = cnn;
    }
    
    public void insertar(MarcasVO vo) throws SQLException{
        PreparedStatement sentencia;
        sentencia = cnn.prepareStatement("INSERT INTO marcas (nombre,detalle)"
                +"VALUES (?,?)");
        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getDetalle());        
        sentencia.executeUpdate();
    }
    
    public void Borrar(MarcasVO vo) throws SQLException{
        PreparedStatement sentencia = 
                cnn.prepareStatement(
                "DELETE marcas"+"WHERE idmarca = ?");
        sentencia.setInt(1, vo.getIdmarca());
        sentencia.executeUpdate();
    }
    
    public void modificar(MarcasVO vo) throws SQLException{
        PreparedStatement sentencia=
                cnn.prepareStatement(
                        "UPDATE marcas SET nombre = ?, detalle = ?"
                        + "WHERE idmarca = ?");
        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getDetalle());
        sentencia.setInt(1, vo.getIdmarca());
        sentencia.executeUpdate();        
    }
    public List<MarcasVO> consultar() throws SQLException{
        List<MarcasVO> listaMarcas = new ArrayList<>();
        
        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM marcas");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            MarcasVO voTemp = new MarcasVO();
            voTemp.setIdmarca(resultado.getInt("idmarca"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setDetalle(resultado.getString("detalle"));            
            listaMarcas.add(voTemp);
        }
        if(listaMarcas.size() > 0){
            return listaMarcas;
        }else{
            return null;
        }
        
    }
}
