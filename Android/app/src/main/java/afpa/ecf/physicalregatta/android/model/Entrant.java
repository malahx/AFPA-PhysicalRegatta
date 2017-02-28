/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.android.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author gwenole
 */
public class Entrant implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private boolean ffv;
    private int numLicence;
    private int yearPermit;
    private Date birth;
    private Collection<Compete> competeCollection;
    private Collection<Compete> competeCollection1;
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

    public Collection<Compete> getCompeteCollection() {
        return competeCollection;
    }

    public void setCompeteCollection(Collection<Compete> competeCollection) {
        this.competeCollection = competeCollection;
    }

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
