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
@Table(name = "pontosdevalidacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pontosdevalidacao.findAll", query = "SELECT p FROM Pontosdevalidacao p"),
    @NamedQuery(name = "Pontosdevalidacao.findByIdpontosdevalidacao", query = "SELECT p FROM Pontosdevalidacao p WHERE p.idpontosdevalidacao = :idpontosdevalidacao"),
    @NamedQuery(name = "Pontosdevalidacao.findByDescricaopontosdevalidacao", query = "SELECT p FROM Pontosdevalidacao p WHERE p.descricaopontosdevalidacao = :descricaopontosdevalidacao")})
public class Pontosdevalidacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpontosdevalidacao")
    private Integer idpontosdevalidacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricaopontosdevalidacao")
    private String descricaopontosdevalidacao;

    public Pontosdevalidacao() {
    }

    public Pontosdevalidacao(Integer idpontosdevalidacao) {
        this.idpontosdevalidacao = idpontosdevalidacao;
    }

    public Pontosdevalidacao(Integer idpontosdevalidacao, String descricaopontosdevalidacao) {
        this.idpontosdevalidacao = idpontosdevalidacao;
        this.descricaopontosdevalidacao = descricaopontosdevalidacao;
    }

    public Integer getIdpontosdevalidacao() {
        return idpontosdevalidacao;
    }

    public void setIdpontosdevalidacao(Integer idpontosdevalidacao) {
        this.idpontosdevalidacao = idpontosdevalidacao;
    }

    public String getDescricaopontosdevalidacao() {
        return descricaopontosdevalidacao;
    }

    public void setDescricaopontosdevalidacao(String descricaopontosdevalidacao) {
        this.descricaopontosdevalidacao = descricaopontosdevalidacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpontosdevalidacao != null ? idpontosdevalidacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pontosdevalidacao)) {
            return false;
        }
        Pontosdevalidacao other = (Pontosdevalidacao) object;
        if ((this.idpontosdevalidacao == null && other.idpontosdevalidacao != null) || (this.idpontosdevalidacao != null && !this.idpontosdevalidacao.equals(other.idpontosdevalidacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Pontosdevalidacao[ idpontosdevalidacao=" + idpontosdevalidacao + " ]";
    }
    
}
