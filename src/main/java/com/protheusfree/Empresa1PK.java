/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.protheusfree;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danielsydow
 */
@Embeddable
public class Empresa1PK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idempresa")
    private int idempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private int idusuario;

    public Empresa1PK() {
    }

    public Empresa1PK(int idempresa, int idusuario) {
        this.idempresa = idempresa;
        this.idusuario = idusuario;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idempresa;
        hash += (int) idusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa1PK)) {
            return false;
        }
        Empresa1PK other = (Empresa1PK) object;
        if (this.idempresa != other.idempresa) {
            return false;
        }
        if (this.idusuario != other.idusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Empresa1PK[ idempresa=" + idempresa + ", idusuario=" + idusuario + " ]";
    }
    
}
