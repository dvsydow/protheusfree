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
public class Consultor1PK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idconsultor")
    private int idconsultor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private int idusuario;

    public Consultor1PK() {
    }

    public Consultor1PK(int idconsultor, int idusuario) {
        this.idconsultor = idconsultor;
        this.idusuario = idusuario;
    }

    public int getIdconsultor() {
        return idconsultor;
    }

    public void setIdconsultor(int idconsultor) {
        this.idconsultor = idconsultor;
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
        hash += (int) idconsultor;
        hash += (int) idusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultor1PK)) {
            return false;
        }
        Consultor1PK other = (Consultor1PK) object;
        if (this.idconsultor != other.idconsultor) {
            return false;
        }
        if (this.idusuario != other.idusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Consultor1PK[ idconsultor=" + idconsultor + ", idusuario=" + idusuario + " ]";
    }
    
}
