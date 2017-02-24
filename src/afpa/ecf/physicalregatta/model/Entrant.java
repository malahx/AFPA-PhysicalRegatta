/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "entrant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrant.findAll", query = "SELECT e FROM Entrant e")
    , @NamedQuery(name = "Entrant.findById", query = "SELECT e FROM Entrant e WHERE e.id = :id")
    , @NamedQuery(name = "Entrant.findByFfv", query = "SELECT e FROM Entrant e WHERE e.ffv = :ffv")
    , @NamedQuery(name = "Entrant.findByNumLicence", query = "SELECT e FROM Entrant e WHERE e.numLicence = :numLicence")
    , @NamedQuery(name = "Entrant.findByYearPermit", query = "SELECT e FROM Entrant e WHERE e.yearPermit = :yearPermit")
    , @NamedQuery(name = "Entrant.findByBirth", query = "SELECT e FROM Entrant e WHERE e.birth = :birth")})
public class Entrant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ffv")
    private boolean ffv;
    @Basic(optional = false)
    @Column(name = "num_licence")
    private int numLicence;
    @Basic(optional = false)
    @Column(name = "year_permit")
    private int yearPermit;
    @Basic(optional = false)
    @Column(name = "birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;
    @ManyToMany(mappedBy = "entrantCollection")
    private Collection<Compete> competeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entrantId")
    private Collection<Compete> competeCollection1;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Person personId;

    public Entrant() {
    }

    public Entrant(Integer id) {
        this.id = id;
    }

    public Entrant(Integer id, boolean ffv, int numLicence, int yearPermit, Date birth) {
        this.id = id;
        this.ffv = ffv;
        this.numLicence = numLicence;
        this.yearPermit = yearPermit;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getFfv() {
        return ffv;
    }

    public void setFfv(boolean ffv) {
        this.ffv = ffv;
    }

    public int getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(int numLicence) {
        this.numLicence = numLicence;
    }

    public int getYearPermit() {
        return yearPermit;
    }

    public void setYearPermit(int yearPermit) {
        this.yearPermit = yearPermit;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @XmlTransient
    public Collection<Compete> getCompeteCollection() {
        return competeCollection;
    }

    public void setCompeteCollection(Collection<Compete> competeCollection) {
        this.competeCollection = competeCollection;
    }

    @XmlTransient
    public Collection<Compete> getCompeteCollection1() {
        return competeCollection1;
    }

    public void setCompeteCollection1(Collection<Compete> competeCollection1) {
        this.competeCollection1 = competeCollection1;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
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
        if (!(object instanceof Entrant)) {
            return false;
        }
        Entrant other = (Entrant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "afpa.ecf.physicalregatta.model.Entrant[ id=" + id + " ]";
    }
    
}
