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
public class ProveedorVO {
    private int idproveedor;
    private String nomempresa;
    private String web;
    private String contacto;
    private String nomcontacto;
    private String ciudad;
    private String pais;    

    /**
     * @return the idproveedor
     */
    public int getIdproveedor() {
        return idproveedor;
    }

    /**
     * @param idproveedor the idproveedor to set
     */
    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    /**
     * @return the nomempresa
     */
    public String getNomempresa() {
        return nomempresa;
    }

    /**
     * @param nomempresa the nomempresa to set
     */
    public void setNomempresa(String nomempresa) {
        this.nomempresa = nomempresa;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * @return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * @return the nomcontacto
     */
    public String getNomcontacto() {
        return nomcontacto;
    }

    /**
     * @param nomcontacto the nomcontacto to set
     */
    public void setNomcontacto(String nomcontacto) {
        this.nomcontacto = nomcontacto;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

   
}
