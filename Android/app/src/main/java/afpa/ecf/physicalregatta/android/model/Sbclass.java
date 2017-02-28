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
public class Sbclass implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private float coef;
    private Collection<Sailboat> sailboatCollection;
    private Serie serieId;

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
