/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elliot
 */
@Entity
@Table(name = "codigo_defecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoDefecto.findAll", query = "SELECT c FROM CodigoDefecto c")
    , @NamedQuery(name = "CodigoDefecto.findByArea", query = "SELECT c FROM CodigoDefecto c WHERE c.area = :area")
    , @NamedQuery(name = "CodigoDefecto.findByMaquina", query = "SELECT c FROM CodigoDefecto c WHERE c.maquina = :maquina")
    , @NamedQuery(name = "CodigoDefecto.findByGravedad", query = "SELECT c FROM CodigoDefecto c WHERE c.gravedad = :gravedad")
    , @NamedQuery(name = "CodigoDefecto.findByDescripcion", query = "SELECT c FROM CodigoDefecto c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "CodigoDefecto.findByCodigoDefecto", query = "SELECT c FROM CodigoDefecto c WHERE c.codigoDefecto = :codigoDefecto")})
public class CodigoDefecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "area")
    private String area;
    @Basic(optional = false)
    @Column(name = "maquina")
    private String maquina;
    @Basic(optional = false)
    @Column(name = "gravedad")
    private String gravedad;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoDefecto")
    private String codigoDefecto;
    @Lob
    @Column(name = "fotografia")
    private byte[] fotografia;

    public CodigoDefecto() {
    }

    public CodigoDefecto(String codigoDefecto) {
        this.codigoDefecto = codigoDefecto;
    }

    public CodigoDefecto(String codigoDefecto, String area, String maquina, String gravedad, String descripcion) {
        this.codigoDefecto = codigoDefecto;
        this.area = area;
        this.maquina = maquina;
        this.gravedad = gravedad;
        this.descripcion = descripcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoDefecto() {
        return codigoDefecto;
    }

    public void setCodigoDefecto(String codigoDefecto) {
        this.codigoDefecto = codigoDefecto;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDefecto != null ? codigoDefecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoDefecto)) {
            return false;
        }
        CodigoDefecto other = (CodigoDefecto) object;
        if ((this.codigoDefecto == null && other.codigoDefecto != null) || (this.codigoDefecto != null && !this.codigoDefecto.equals(other.codigoDefecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.furukawa.reportsystem.entidad.CodigoDefecto[ codigoDefecto=" + codigoDefecto + " ]";
    }
    
}
