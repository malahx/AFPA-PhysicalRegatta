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
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Collection<Sbclass> sbclassCollection;

    public Serie() {
    }

    public Serie(Integer id) {
        this.id = id;
    }

    public Serie(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Collection<Sbclass> getSbclassCollection() {
        return sbclassCollection;
    }

    public void setSbclassCollection(Collection<Sbclass> sbclassCollection) {
        this.sbclassCollection = sbclassCollection;
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
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
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
