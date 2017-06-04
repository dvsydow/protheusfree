/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.protheusfree;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danielsydow
 */
@Entity
@Table(name = "especialidadesconsultor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidadesconsultor.findAll", query = "SELECT e FROM Especialidadesconsultor e"),
    @NamedQuery(name = "Especialidadesconsultor.findByIdespecialidadesconsultor", query = "SELECT e FROM Especialidadesconsultor e WHERE e.idespecialidadesconsultor = :idespecialidadesconsultor"),
    @NamedQuery(name = "Especialidadesconsultor.findByIdespecialidades", query = "SELECT e FROM Especialidadesconsultor e WHERE e.idespecialidades = :idespecialidades"),
    @NamedQuery(name = "Especialidadesconsultor.findByIdconsultor", query = "SELECT e FROM Especialidadesconsultor e WHERE e.idconsultor = :idconsultor")})
public class Especialidadesconsultor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idespecialidadesconsultor")
    private Integer idespecialidadesconsultor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idespecialidades")
    private int idespecialidades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idconsultor")
    private int idconsultor;

    public Especialidadesconsultor() {
    }

    public Especialidadesconsultor(Integer idespecialidadesconsultor) {
        this.idespecialidadesconsultor = idespecialidadesconsultor;
    }

    public Especialidadesconsultor(Integer idespecialidadesconsultor, int idespecialidades, int idconsultor) {
        this.idespecialidadesconsultor = idespecialidadesconsultor;
        this.idespecialidades = idespecialidades;
        this.idconsultor = idconsultor;
    }

    public Integer getIdespecialidadesconsultor() {
        return idespecialidadesconsultor;
    }

    public void setIdespecialidadesconsultor(Integer idespecialidadesconsultor) {
        this.idespecialidadesconsultor = idespecialidadesconsultor;
    }

    public int getIdespecialidades() {
        return idespecialidades;
    }

    public void setIdespecialidades(int idespecialidades) {
        this.idespecialidades = idespecialidades;
    }

    public int getIdconsultor() {
        return idconsultor;
    }

    public void setIdconsultor(int idconsultor) {
        this.idconsultor = idconsultor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecialidadesconsultor != null ? idespecialidadesconsultor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidadesconsultor)) {
            return false;
        }
        Especialidadesconsultor other = (Especialidadesconsultor) object;
        if ((this.idespecialidadesconsultor == null && other.idespecialidadesconsultor != null) || (this.idespecialidadesconsultor != null && !this.idespecialidadesconsultor.equals(other.idespecialidadesconsultor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Especialidadesconsultor[ idespecialidadesconsultor=" + idespecialidadesconsultor + " ]";
    }
    
}
