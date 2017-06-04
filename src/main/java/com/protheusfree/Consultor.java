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
import javax.persistence.Lob;
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
@Table(name = "consultor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultor.findAll", query = "SELECT c FROM Consultor c"),
    @NamedQuery(name = "Consultor.findByIdconsultor", query = "SELECT c FROM Consultor c WHERE c.idconsultor = :idconsultor"),
    @NamedQuery(name = "Consultor.findByNomeconsultor", query = "SELECT c FROM Consultor c WHERE c.nomeconsultor = :nomeconsultor"),
    @NamedQuery(name = "Consultor.findByCpfcnpjconsultor", query = "SELECT c FROM Consultor c WHERE c.cpfcnpjconsultor = :cpfcnpjconsultor"),
    @NamedQuery(name = "Consultor.findByFacebookconsultor", query = "SELECT c FROM Consultor c WHERE c.facebookconsultor = :facebookconsultor"),
    @NamedQuery(name = "Consultor.findByEmailconsultor", query = "SELECT c FROM Consultor c WHERE c.emailconsultor = :emailconsultor"),
    @NamedQuery(name = "Consultor.findByCelularconsultor", query = "SELECT c FROM Consultor c WHERE c.celularconsultor = :celularconsultor"),
    @NamedQuery(name = "Consultor.findBySenhaconsultor", query = "SELECT c FROM Consultor c WHERE c.senhaconsultor = :senhaconsultor"),
    @NamedQuery(name = "Consultor.findByIndicadorconsultor", query = "SELECT c FROM Consultor c WHERE c.indicadorconsultor = :indicadorconsultor")})
public class Consultor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsultor")
    private Integer idconsultor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomeconsultor")
    private String nomeconsultor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpfcnpjconsultor")
    private long cpfcnpjconsultor;
    @Size(max = 100)
    @Column(name = "facebookconsultor")
    private String facebookconsultor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "emailconsultor")
    private String emailconsultor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "celularconsultor")
    private String celularconsultor;
    @Lob
    @Column(name = "fotoconsultor")
    private byte[] fotoconsultor;
    @Size(max = 100)
    @Column(name = "senhaconsultor")
    private String senhaconsultor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indicadorconsultor")
    private int indicadorconsultor;

    public Consultor() {
    }

    public Consultor(Integer idconsultor) {
        this.idconsultor = idconsultor;
    }

    public Consultor(Integer idconsultor, String nomeconsultor, long cpfcnpjconsultor, String emailconsultor, String celularconsultor, int indicadorconsultor) {
        this.idconsultor = idconsultor;
        this.nomeconsultor = nomeconsultor;
        this.cpfcnpjconsultor = cpfcnpjconsultor;
        this.emailconsultor = emailconsultor;
        this.celularconsultor = celularconsultor;
        this.indicadorconsultor = indicadorconsultor;
    }

    public Integer getIdconsultor() {
        return idconsultor;
    }

    public void setIdconsultor(Integer idconsultor) {
        this.idconsultor = idconsultor;
    }

    public String getNomeconsultor() {
        return nomeconsultor;
    }

    public void setNomeconsultor(String nomeconsultor) {
        this.nomeconsultor = nomeconsultor;
    }

    public long getCpfcnpjconsultor() {
        return cpfcnpjconsultor;
    }

    public void setCpfcnpjconsultor(long cpfcnpjconsultor) {
        this.cpfcnpjconsultor = cpfcnpjconsultor;
    }

    public String getFacebookconsultor() {
        return facebookconsultor;
    }

    public void setFacebookconsultor(String facebookconsultor) {
        this.facebookconsultor = facebookconsultor;
    }

    public String getEmailconsultor() {
        return emailconsultor;
    }

    public void setEmailconsultor(String emailconsultor) {
        this.emailconsultor = emailconsultor;
    }

    public String getCelularconsultor() {
        return celularconsultor;
    }

    public void setCelularconsultor(String celularconsultor) {
        this.celularconsultor = celularconsultor;
    }

    public byte[] getFotoconsultor() {
        return fotoconsultor;
    }

    public void setFotoconsultor(byte[] fotoconsultor) {
        this.fotoconsultor = fotoconsultor;
    }

    public String getSenhaconsultor() {
        return senhaconsultor;
    }

    public void setSenhaconsultor(String senhaconsultor) {
        this.senhaconsultor = senhaconsultor;
    }

    public int getIndicadorconsultor() {
        return indicadorconsultor;
    }

    public void setIndicadorconsultor(int indicadorconsultor) {
        this.indicadorconsultor = indicadorconsultor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsultor != null ? idconsultor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultor)) {
            return false;
        }
        Consultor other = (Consultor) object;
        if ((this.idconsultor == null && other.idconsultor != null) || (this.idconsultor != null && !this.idconsultor.equals(other.idconsultor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.protheusfree.Consultor[ idconsultor=" + idconsultor + " ]";
    }
    
}
