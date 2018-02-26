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
public class ProductosVO {
    private int idproducto;
    private String nombre;
    private int marca;
    private float costo;
    private float precio;
    private Date fechavencimineto;
    private int cantidad;
    private int proveedor;

    /**
     * @return the idproducto
     */
    public int getIdproducto() {
        return idproducto;
    }

    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
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
     * @return the marca
     */
    public int getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(int marca) {
        this.marca = marca;
    }

    /**
     * @return the costo
     */
    public float getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the fechavencimineto
     */
    public Date getFechavencimineto() {
        return fechavencimineto;
    }

    /**
     * @param fechavencimineto the fechavencimineto to set
     */
    public void setFechavencimineto(Date fechavencimineto) {
        this.fechavencimineto = fechavencimineto;
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

    /**
     * @return the proveedor
     */
    public int getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
}
