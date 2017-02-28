/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.model;

import com.google.gson.annotations.Expose;
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
@Table(name = "sbclass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sbclass.findAll", query = "SELECT s FROM Sbclass s")
    , @NamedQuery(name = "Sbclass.findById", query = "SELECT s FROM Sbclass s WHERE s.id = :id")
    , @NamedQuery(name = "Sbclass.findByName", query = "SELECT s FROM Sbclass s WHERE s.name = :name")
    , @NamedQuery(name = "Sbclass.findByCoef", query = "SELECT s FROM Sbclass s WHERE s.coef = :coef")})
public class Sbclass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @Expose private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    @Expose private String name;
    @Basic(optional = false)
    @Column(name = "coef")
    @Expose private float coef;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classId")
    private Collection<Sailboat> sailboatCollection;
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @Expose private Serie serieId;

    public Sbclass() {
    }

    public Sbclass(Integer id) {
        this.id = id;
    }

    public Sbclass(Integer id, String name, float coef) {
        this.id = id;
        this.name = name;
        this.coef = coef;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    @XmlTransient
    public Collection<Sailboat> getSailboatCollection() {
        return sailboatCollection;
    }

    public void setSailboatCollection(Collection<Sailboat> sailboatCollection) {
        this.sailboatCollection = sailboatCollection;
    }

    public Serie getSerieId() {
        return serieId;
    }

    public void setSerieId(Serie serieId) {
        this.serieId = serieId;
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
        if (!(object instanceof Sbclass)) {
            return false;
        }
        Sbclass other = (Sbclass) object;
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
