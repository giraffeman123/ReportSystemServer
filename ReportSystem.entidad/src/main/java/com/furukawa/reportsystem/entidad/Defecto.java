/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Elliot
 */
@Entity
@Table(name = "defecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Defecto.findAll", query = "SELECT d FROM Defecto d")
    , @NamedQuery(name = "Defecto.findByCodigoDefecto", query = "SELECT d FROM Defecto d WHERE d.codigoDefecto = :codigoDefecto")
    , @NamedQuery(name = "Defecto.findByCantidad", query = "SELECT d FROM Defecto d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Defecto.findByFecha", query = "SELECT d FROM Defecto d WHERE d.fecha = :fecha")
    , @NamedQuery(name = "Defecto.findByComentario", query = "SELECT d FROM Defecto d WHERE d.comentario = :comentario")})
public class Defecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoDefecto")
    private String codigoDefecto;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "asociado", referencedColumnName = "codigoEmpleado")
    @ManyToOne(optional = false)
    private Empleado asociado;
    @JoinColumn(name = "codigoDefecto", referencedColumnName = "codigoDefecto", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CodigoDefecto codigoDefecto1;
    @JoinColumn(name = "lider", referencedColumnName = "codigoEmpleado")
    @ManyToOne(optional = false)
    private Lider lider;

    public Defecto() {
    }

    public Defecto(String codigoDefecto) {
        this.codigoDefecto = codigoDefecto;
    }

    public Defecto(String codigoDefecto, int cantidad, Date fecha) {
        this.codigoDefecto = codigoDefecto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getCodigoDefecto() {
        return codigoDefecto;
    }

    public void setCodigoDefecto(String codigoDefecto) {
        this.codigoDefecto = codigoDefecto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Empleado getAsociado() {
        return asociado;
    }

    public void setAsociado(Empleado asociado) {
        this.asociado = asociado;
    }

    public CodigoDefecto getCodigoDefecto1() {
        return codigoDefecto1;
    }

    public void setCodigoDefecto1(CodigoDefecto codigoDefecto1) {
        this.codigoDefecto1 = codigoDefecto1;
    }

    public Lider getLider() {
        return lider;
    }

    public void setLider(Lider lider) {
        this.lider = lider;
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
        if (!(object instanceof Defecto)) {
            return false;
        }
        Defecto other = (Defecto) object;
        if ((this.codigoDefecto == null && other.codigoDefecto != null) || (this.codigoDefecto != null && !this.codigoDefecto.equals(other.codigoDefecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.furukawa.reportsystem.entidad.Defecto[ codigoDefecto=" + codigoDefecto + " ]";
    }
    
}
