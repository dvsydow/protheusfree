/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.protheusfree;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danielsydow
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByEmailusuario", query = "SELECT u FROM Usuario u WHERE u.emailusuario = :emailusuario"),
    @NamedQuery(name = "Usuario.findBySenhausuario", query = "SELECT u FROM Usuario u WHERE u.senhausuario = :senhausuario")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "emailusuario")
    private String emailusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senhausuario")
    private String senhausuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Consultor1> consultor1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Empresa1> empresa1Collection;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String emailusuario, String senhausuario) {
        this.idusuario = idusuario;
        this.emailusuario = emailusuario;
        this.senhausuario = senhausuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public String getSenhausuario() {
        return senhausuario;
    }

    public void setSenhausuario(String senhausuario) {
        this.senhausuario = senhausuario;
    }

    @XmlTransient
    public Collection<Consultor1> getConsultor1Collection() {
        return consultor1Collection;
    }

    public void setConsultor1Collection(Collection<Consultor1> consultor1Collection) {
        this.consultor1Collection = consultor1Collection;
    }

    @XmlTransient
    public Collection<Empresa1> getEmpresa1Collection() {
        return empresa1Collection;
    }

    public void setEmpresa1Collection(Collection<Empresa1> empresa1Collection) {
        this.empresa1Collection = empresa1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
