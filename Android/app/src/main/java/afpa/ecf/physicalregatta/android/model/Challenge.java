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

public class Challenge implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String code;
    private String name;
    private Date begin;
    private Date end;
    private Collection<Regatta> regattaCollection;

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
