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
public class Auditor implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Collection<Regatta> regattaCollection;
    private Committee committeeId;
    private Person personId;

    public Auditor() {
    }

    public Auditor(Integer id) {
        this.id = id;
    }

//    public Auditor(JSONObject jsonObject) {
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<Regatta> getRegattaCollection() {
        return regattaCollection;
    }

    public void setRegattaCollection(Collection<Regatta> regattaCollection) {
        this.regattaCollection = regattaCollection;
    }

    public Committee getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(Committee committeeId) {
        this.committeeId = committeeId;
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
        if (!(object instanceof Auditor)) {
            return false;
        }
        Auditor other = (Auditor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "afpa.ecf.physicalregatta.model.Auditor[ id=" + id + " ]";
    }
    
}
