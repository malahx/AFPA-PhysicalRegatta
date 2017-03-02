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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "regatta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regatta.findAll", query = "SELECT r FROM Regatta r")
    , @NamedQuery(name = "Regatta.findById", query = "SELECT r FROM Regatta r WHERE r.id = :id")
    , @NamedQuery(name = "Regatta.findByCode", query = "SELECT r FROM Regatta r WHERE r.code = :code")
    , @NamedQuery(name = "Regatta.findByName", query = "SELECT r FROM Regatta r WHERE r.name = :name")
    , @NamedQuery(name = "Regatta.findByDate", query = "SELECT r FROM Regatta r WHERE r.date = :date")
    , @NamedQuery(name = "Regatta.findByDistance", query = "SELECT r FROM Regatta r WHERE r.distance = :distance")})
public class Regatta implements Serializable {

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
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @Expose private Date date;
    @Basic(optional = false)
    @Column(name = "distance")
    @Expose private float distance;
    @ManyToMany(mappedBy = "regattaCollection", fetch = FetchType.EAGER)
    @Expose private Collection<Auditor> auditorCollection;
    @ManyToMany(mappedBy = "regattaCollection", fetch = FetchType.EAGER)
    @Expose private Collection<Jury> juryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regattaId", fetch = FetchType.EAGER)
    @Expose private Collection<Compete> competeCollection;
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Challenge challengeId;

    public Regatta() {
    }

    public Regatta(Integer id) {
        this.id = id;
    }

    public Regatta(Integer id, String code, String name, Date date, float distance) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.date = date;
        this.distance = distance;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @XmlTransient
    public Collection<Auditor> getAuditorCollection() {
        return auditorCollection;
    }

    public void setAuditorCollection(Collection<Auditor> auditorCollection) {
        this.auditorCollection = auditorCollection;
    }

    @XmlTransient
    public Collection<Jury> getJuryCollection() {
        return juryCollection;
    }

    public void setJuryCollection(Collection<Jury> juryCollection) {
        this.juryCollection = juryCollection;
    }

    @XmlTransient
    public Collection<Compete> getCompeteCollection() {
        return competeCollection;
    }

    public void setCompeteCollection(Collection<Compete> competeCollection) {
        this.competeCollection = competeCollection;
    }

    public Challenge getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Challenge challengeId) {
        this.challengeId = challengeId;
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
        if (!(object instanceof Regatta)) {
            return false;
        }
        Regatta other = (Regatta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
