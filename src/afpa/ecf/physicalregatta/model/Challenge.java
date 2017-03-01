/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gwenole
 */
@Entity
@Table(name = "challenge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Challenge.findAll", query = "SELECT c FROM Challenge c")
    , @NamedQuery(name = "Challenge.findById", query = "SELECT c FROM Challenge c WHERE c.id = :id")
    , @NamedQuery(name = "Challenge.findByCode", query = "SELECT c FROM Challenge c WHERE c.code = :code")
    , @NamedQuery(name = "Challenge.findByName", query = "SELECT c FROM Challenge c WHERE c.name = :name")
    , @NamedQuery(name = "Challenge.findByBegin", query = "SELECT c FROM Challenge c WHERE c.begin = :begin")
    , @NamedQuery(name = "Challenge.findByEnd", query = "SELECT c FROM Challenge c WHERE c.end = :end")})
public class Challenge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @Expose private Integer id;
    @Basic(optional = false)
    @Column(name = "code")
    @Expose private String code;
    @Basic(optional = false)
    @Column(name = "name")
    @Expose private String name;
    @Basic(optional = false)
    @Column(name = "begin")
    @Temporal(TemporalType.TIMESTAMP)
    @Expose private Date begin;
    @Basic(optional = false)
    @Column(name = "end")
    @Temporal(TemporalType.TIMESTAMP)
    @Expose private Date end;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "challengeId")
    @Expose private Collection<Regatta> regattaCollection;

    public Challenge() {
    }

    public Challenge(Integer id) {
        this.id = id;
    }

    public Challenge(Integer id, String code, String name, Date begin, Date end) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @XmlTransient
    public Collection<Regatta> getRegattaCollection() {
        return regattaCollection;
    }

    public void setRegattaCollection(Collection<Regatta> regattaCollection) {
        this.regattaCollection = regattaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Challenge)) {
            return false;
        }
        Challenge other = (Challenge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "afpa.ecf.physicalregatta.model.Challenge[ id=" + id + " ]";
    }
    
}
