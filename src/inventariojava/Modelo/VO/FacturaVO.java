/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Modelo.VO;

import java.util.Date;

/**
 *
 * @author luism
 */
public class FacturaVO {
    private int idfactura;
    private String nombre;
    private Date fecha;
    private int empleado;
    private int producto;
    private int cantidad;

    /**
     * @return the idfactura
     */
    public int getIdfactura() {
        return idfactura;
    }

    /**
     * @param idfactura the idfactura to set
     */
    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the empleado
     */
    public int getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the producto
     */
    public int getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(int producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
