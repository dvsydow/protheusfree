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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danielsydow
 */
@Entity
@Table(name = "especialidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidades.findAll", query = "SELECT e FROM Especialidades e"),
    @NamedQuery(name = "Especialidades.findByIdespecialidades", query = "SELECT e FROM Especialidades e WHERE e.idespecialidades = :idespecialidades"),
    @NamedQuery(name = "Especialidades.findByDescricaoespecialidades", query = "SELECT e FROM Especialidades e WHERE e.descricaoespecialidades = :descricaoespecialidades")})
public class Especialidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idespecialidades")
    private Integer idespecialidades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricaoespecialidades")
    private String descricaoespecialidades;

    public Especialidades() {
    }

    public Especialidades(Integer idespecialidades) {
        this.idespecialidades = idespecialidades;
    }

    public Especialidades(Integer idespecialidades, String descricaoespecialidades) {
        this.idespecialidades = idespecialidades;
        this.descricaoespecialidades = descricaoespecialidades;
    }

    public Integer getIdespecialidades() {
        return idespecialidades;
    }

    public void setIdespecialidades(Integer idespecialidades) {
        this.idespecialidades = idespecialidades;
    }

    public String getDescricaoespecialidades() {
        return descricaoespecialidades;
    }

    public void setDescricaoespecialidades(String descricaoespecialidades) {
        this.descricaoespecialidades = descricaoespecialidades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecialidades != null ? idespecialidades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidades)) {
            return false;
        }
        Especialidades other = (Especialidades) object;
        if ((this.idespecialidades == null && other.idespecialidades != null) || (this.idespecialidades != null && !this.idespecialidades.equals(other.idespecialidades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Especialidades[ idespecialidades=" + idespecialidades + " ]";
    }
    
}
