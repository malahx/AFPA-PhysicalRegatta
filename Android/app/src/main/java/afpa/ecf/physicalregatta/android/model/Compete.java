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
public class Compete implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private int point;
    private Boolean valid;
    private float realtime;
    private Integer position;
    private Collection<Entrant> entrantCollection;
    private Entrant entrantId;
    private Regatta regattaId;
    private Report reportId;
    private Sailboat sailboatId;

    public Compete() {
    }

    public Compete(Integer id) {
        this.id = id;
    }

    public Compete(Integer id, int point, float realtime) {
        this.id = id;
        this.point = point;
        this.realtime = realtime;
    }

//    public Compete(JSONObject jsonObject) {
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public float getRealtime() {
        return realtime;
    }

    public void setRealtime(float realtime) {
        this.realtime = realtime;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Collection<Entrant> getEntrantCollection() {
        return entrantCollection;
    }

    public void setEntrantCollection(Collection<Entrant> entrantCollection) {
        this.entrantCollection = entrantCollection;
    }

    public Entrant getEntrantId() {
        return entrantId;
    }

    public void setEntrantId(Entrant entrantId) {
        this.entrantId = entrantId;
    }

    public Regatta getRegattaId() {
        return regattaId;
    }

    public void setRegattaId(Regatta regattaId) {
        this.regattaId = regattaId;
    }

    public Report getReportId() {
        return reportId;
    }

    public void setReportId(Report reportId) {
        this.reportId = reportId;
    }

    public Sailboat getSailboatId() {
        return sailboatId;
    }

    public void setSailboatId(Sailboat sailboatId) {
        this.sailboatId = sailboatId;
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
        if (!(object instanceof Compete)) {
            return false;
        }
        Compete other = (Compete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "afpa.ecf.physicalregatta.model.Compete[ id=" + id + " ]";
    }
    
}
