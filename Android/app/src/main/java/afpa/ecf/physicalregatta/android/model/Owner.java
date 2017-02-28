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
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Club clubId;
    private Person personId;
    private Collection<Sailboat> sailboatCollection;

    public Owner() {
    }

    public Owner(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Club getClubId() {
        return clubId;
    }

    public void setClubId(Club clubId) {
        this.clubId = clubId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Collection<Sailboat> getSailboatCollection() {
        return sailboatCollection;
    }

    public void setSailboatCollection(Collection<Sailboat> sailboatCollection) {
        this.sailboatCollection = sailboatCollection;
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
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return personId.toString();
    }
    
}
