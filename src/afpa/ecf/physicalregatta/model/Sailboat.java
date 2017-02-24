/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gwenole
 */
@Entity
@Table(name = "sailboat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sailboat.findAll", query = "SELECT s FROM Sailboat s")
    , @NamedQuery(name = "Sailboat.findById", query = "SELECT s FROM Sailboat s WHERE s.id = :id")
    , @NamedQuery(name = "Sailboat.findByNumSail", query = "SELECT s FROM Sailboat s WHERE s.numSail = :numSail")})
public class Sailboat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "num_sail")
    private int numSail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sailboatId")
    private Collection<Compete> competeCollection;
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sbclass classId;
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Owner ownerId;

    public Sailboat() {
    }

    public Sailboat(Integer id) {
        this.id = id;
    }

    public Sailboat(Integer id, int numSail) {
        this.id = id;
        this.numSail = numSail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumSail() {
        return numSail;
    }

    public void setNumSail(int numSail) {
        this.numSail = numSail;
    }

    @XmlTransient
    public Collection<Compete> getCompeteCollection() {
        return competeCollection;
    }

    public void setCompeteCollection(Collection<Compete> competeCollection) {
        this.competeCollection = competeCollection;
    }

    public Sbclass getClassId() {
        return classId;
    }

    public void setClassId(Sbclass classId) {
        this.classId = classId;
    }

    public Owner getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Owner ownerId) {
        this.ownerId = ownerId;
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
        if (!(object instanceof Sailboat)) {
            return false;
        }
        Sailboat other = (Sailboat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "afpa.ecf.physicalregatta.model.Sailboat[ id=" + id + " ]";
    }
    
}
