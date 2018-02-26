/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventariojava.Modelo.VO;

/**
 *
 * @author luism
 */
public class MarcasVO {
    private int idmarca;
    private String Nombre;
    private String Detalle;

    /**
     * @return the idmarca
     */
    public int getIdmarca() {
        return idmarca;
    }

    /**
     * @param idmarca the idmarca to set
     */
    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Detalle
     */
    public String getDetalle() {
        return Detalle;
    }

    /**
     * @param Detalle the Detalle to set
     */
    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }
    
}
