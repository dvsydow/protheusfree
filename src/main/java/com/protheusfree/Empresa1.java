/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.protheusfree;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empresa1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa1.findAll", query = "SELECT e FROM Empresa1 e"),
    @NamedQuery(name = "Empresa1.findByIdempresa", query = "SELECT e FROM Empresa1 e WHERE e.empresa1PK.idempresa = :idempresa"),
    @NamedQuery(name = "Empresa1.findByIdusuario", query = "SELECT e FROM Empresa1 e WHERE e.empresa1PK.idusuario = :idusuario"),
    @NamedQuery(name = "Empresa1.findByCnpj", query = "SELECT e FROM Empresa1 e WHERE e.cnpj = :cnpj")})
public class Empresa1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Empresa1PK empresa1PK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnpj")
    private int cnpj;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Empresa1() {
    }

    public Empresa1(Empresa1PK empresa1PK) {
        this.empresa1PK = empresa1PK;
    }

    public Empresa1(Empresa1PK empresa1PK, int cnpj) {
        this.empresa1PK = empresa1PK;
        this.cnpj = cnpj;
    }

    public Empresa1(int idempresa, int idusuario) {
        this.empresa1PK = new Empresa1PK(idempresa, idusuario);
    }

    public Empresa1PK getEmpresa1PK() {
        return empresa1PK;
    }

    public void setEmpresa1PK(Empresa1PK empresa1PK) {
        this.empresa1PK = empresa1PK;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresa1PK != null ? empresa1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa1)) {
            return false;
        }
        Empresa1 other = (Empresa1) object;
        if ((this.empresa1PK == null && other.empresa1PK != null) || (this.empresa1PK != null && !this.empresa1PK.equals(other.empresa1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Empresa1[ empresa1PK=" + empresa1PK + " ]";
    }
    
}
