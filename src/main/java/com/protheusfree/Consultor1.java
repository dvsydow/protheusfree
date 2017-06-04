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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danielsydow
 */
@Entity
@Table(name = "consultor1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultor1.findAll", query = "SELECT c FROM Consultor1 c"),
    @NamedQuery(name = "Consultor1.findByIdconsultor", query = "SELECT c FROM Consultor1 c WHERE c.consultor1PK.idconsultor = :idconsultor"),
    @NamedQuery(name = "Consultor1.findByIdusuario", query = "SELECT c FROM Consultor1 c WHERE c.consultor1PK.idusuario = :idusuario"),
    @NamedQuery(name = "Consultor1.findByNomeconsultor", query = "SELECT c FROM Consultor1 c WHERE c.nomeconsultor = :nomeconsultor")})
public class Consultor1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Consultor1PK consultor1PK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomeconsultor")
    private String nomeconsultor;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Consultor1() {
    }

    public Consultor1(Consultor1PK consultor1PK) {
        this.consultor1PK = consultor1PK;
    }

    public Consultor1(Consultor1PK consultor1PK, String nomeconsultor) {
        this.consultor1PK = consultor1PK;
        this.nomeconsultor = nomeconsultor;
    }

    public Consultor1(int idconsultor, int idusuario) {
        this.consultor1PK = new Consultor1PK(idconsultor, idusuario);
    }

    public Consultor1PK getConsultor1PK() {
        return consultor1PK;
    }

    public void setConsultor1PK(Consultor1PK consultor1PK) {
        this.consultor1PK = consultor1PK;
    }

    public String getNomeconsultor() {
        return nomeconsultor;
    }

    public void setNomeconsultor(String nomeconsultor) {
        this.nomeconsultor = nomeconsultor;
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
        hash += (consultor1PK != null ? consultor1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultor1)) {
            return false;
        }
        Consultor1 other = (Consultor1) object;
        if ((this.consultor1PK == null && other.consultor1PK != null) || (this.consultor1PK != null && !this.consultor1PK.equals(other.consultor1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Consultor1[ consultor1PK=" + consultor1PK + " ]";
    }
    
}
