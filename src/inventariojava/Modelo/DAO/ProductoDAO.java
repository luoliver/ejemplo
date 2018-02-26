/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Modelo.DAO;

import inventariojava.Modelo.VO.ProductosVO;
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
public class ProductoDAO {
    Connection cnn;

    public ProductoDAO(Connection cnn){
        this.cnn = cnn;
    }

    public void insertar(ProductosVO vo) throws SQLException{
        PreparedStatement sentencia;
        sentencia = cnn.prepareStatement("INSERT INTO productos (nombre,marca,costo,precio,fechavencimineto,cantidad,proveedor)"
                +"VALUES (?,?,?,?,?,?,?)");
        sentencia.setString(1, vo.getNombre());
        sentencia.setInt(2, vo.getMarca());
        sentencia.setFloat(3, vo.getCosto());
        sentencia.setFloat(4, vo.getPrecio());
        sentencia.setDate(5, new java.sql.Date(vo.getFechavencimineto().getTime()));
        sentencia.setInt(6, vo.getCantidad());
        sentencia.setInt(7,vo.getProveedor());
        sentencia.executeUpdate();
    }

    public void Borrar(ProductosVO vo) throws SQLException{
        PreparedStatement sentencia =
                cnn.prepareStatement(
                "DELETE productos"+"WHERE idproducto = ?");
        sentencia.setInt(1, vo.getIdproducto());
        sentencia.executeUpdate();
    }

    public void modificar(ProductosVO vo) throws SQLException{
        PreparedStatement sentencia=
                cnn.prepareStatement(
                        "UPDATE productos SET nombre = ?, marca = ?, costo =?,precio=?,fechavencimineto=?,cantidad=?,proveedor=?"
                        + "WHERE idproducto = ?");
        sentencia.setString(1, vo.getNombre());
        sentencia.setInt(2, vo.getMarca());
        sentencia.setFloat(3, vo.getCosto());
        sentencia.setFloat(4, vo.getPrecio());
        sentencia.setDate(5, new java.sql.Date(vo.getFechavencimineto().getTime()));
        sentencia.setInt(6, vo.getCantidad());
        sentencia.setInt(7,vo.getProveedor());
        sentencia.setInt(8, vo.getIdproducto());
        sentencia.executeUpdate();
    }
    public void descontar(int id, int cantidad) throws SQLException{
        int res = 0;
        PreparedStatement sentenciaAux = cnn.prepareStatement("SELECT * FROM productos "
                + "WHERE idproducto = ?");
        sentenciaAux.setInt(1,id);
        ResultSet resultadoAu =  sentenciaAux.executeQuery();
                
        while (resultadoAu.next()) {
            res = (resultadoAu.getInt("cantidad"))-cantidad;    
        }
               
           
        //---------------------------------
        PreparedStatement sentencia=
                cnn.prepareStatement(
                        "UPDATE productos SET cantidad=? "
                        + "WHERE idproducto = ?");        
        sentencia.setInt(1, res);        
        sentencia.setInt(2, id );
        sentencia.executeUpdate();
    }
    public List<ProductosVO> consultar() throws SQLException{
        List<ProductosVO> listaContactos = new ArrayList<>();

        PreparedStatement sentencia = cnn.prepareStatement("SELECT * FROM productos");
        ResultSet resultado =  sentencia.executeQuery();
        while (resultado.next()) {
            ProductosVO voTemp = new ProductosVO();
            voTemp.setIdproducto(resultado.getInt("idproducto"));
            voTemp.setNombre(resultado.getString("nombre"));
            voTemp.setCantidad(resultado.getInt("cantidad"));
            voTemp.setCosto(resultado.getInt("costo"));
            voTemp.setPrecio(resultado.getInt("precio"));
            voTemp.setMarca(resultado.getInt("marca"));
            voTemp.setFechavencimineto(resultado.getDate("fechavencimineto"));
            voTemp.setProveedor(resultado.getInt("proveedor"));

            listaContactos.add(voTemp);
        }
        if(listaContactos.size() > 0){
            return listaContactos;
        }else{
            return null;
        }

    }
}
