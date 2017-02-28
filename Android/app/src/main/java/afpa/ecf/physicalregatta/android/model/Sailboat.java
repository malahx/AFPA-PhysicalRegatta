/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.android.model;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author gwenole
 */
public class Sailboat implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private int numSail;
    private Collection<Compete> competeCollection;
    private Sbclass classId;
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
