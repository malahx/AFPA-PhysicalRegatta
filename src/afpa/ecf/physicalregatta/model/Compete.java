/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gwenole
 */
@Entity
@Table(name = "compete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compete.findAll", query = "SELECT c FROM Compete c")
    , @NamedQuery(name = "Compete.findById", query = "SELECT c FROM Compete c WHERE c.id = :id")
    , @NamedQuery(name = "Compete.findByPoint", query = "SELECT c FROM Compete c WHERE c.point = :point")
    , @NamedQuery(name = "Compete.findByValid", query = "SELECT c FROM Compete c WHERE c.valid = :valid")
    , @NamedQuery(name = "Compete.findByRealtime", query = "SELECT c FROM Compete c WHERE c.realtime = :realtime")
    , @NamedQuery(name = "Compete.findByPosition", query = "SELECT c FROM Compete c WHERE c.position = :position")})
public class Compete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "point")
    private int point;
    @Column(name = "valid")
    private Boolean valid;
    @Basic(optional = false)
    @Column(name = "realtime")
    private float realtime;
    @Column(name = "position")
    private Integer position;
    @JoinTable(name = "crew", joinColumns = {
        @JoinColumn(name = "compete_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "entrant_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Entrant> entrantCollection;
    @JoinColumn(name = "entrant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Entrant entrantId;
    @JoinColumn(name = "regatta_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Regatta regattaId;
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    @ManyToOne
    private Report reportId;
    @JoinColumn(name = "sailboat_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
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

    @XmlTransient
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
