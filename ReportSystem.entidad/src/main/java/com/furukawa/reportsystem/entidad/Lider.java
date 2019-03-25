/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.entidad;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Elliot
 */
@Entity
@Table(name = "lider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lider.findAll", query = "SELECT l FROM Lider l")
    , @NamedQuery(name = "Lider.findByCodigoEmpleado", query = "SELECT l FROM Lider l WHERE l.codigoEmpleado = :codigoEmpleado")
    , @NamedQuery(name = "Lider.findByArea", query = "SELECT l FROM Lider l WHERE l.area = :area")
    , @NamedQuery(name = "Lider.findByLinea", query = "SELECT l FROM Lider l WHERE l.linea = :linea")})
public class Lider implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoEmpleado")
    @Expose(serialize = true)
    private String codigoEmpleado;
    @Basic(optional = false)
    @Column(name = "area")
    @Expose(serialize = true)
    private String area;
    @Basic(optional = false)
    @Column(name = "linea")
    @Expose(serialize = true)
    private int linea;
    @JoinColumn(name = "codigoEmpleado", referencedColumnName = "codigoEmpleado", insertable = false, updatable = false)
    @OneToOne(optional = false)
    @Expose(serialize = true)
    private Empleado empleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lider")
    @Expose(serialize = true)
    private List<Defecto> defectoList;

    public Lider() {
    }

    public Lider(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public Lider(String codigoEmpleado, String area, int linea) {
        this.codigoEmpleado = codigoEmpleado;
        this.area = area;
        this.linea = linea;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @XmlTransient
    public List<Defecto> getDefectoList() {
        return defectoList;
    }

    public void setDefectoList(List<Defecto> defectoList) {
        this.defectoList = defectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoEmpleado != null ? codigoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lider)) {
            return false;
        }
        Lider other = (Lider) object;
        if ((this.codigoEmpleado == null && other.codigoEmpleado != null) || (this.codigoEmpleado != null && !this.codigoEmpleado.equals(other.codigoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.furukawa.reportsystem.entidad.Lider[ codigoEmpleado=" + codigoEmpleado + " ]";
    }
    
}
