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
public class Regatta implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private float distance;
    private Collection<Auditor> auditorCollection;
    private Collection<Jury> juryCollection;
    private Collection<Compete> competeCollection;
    private Challenge challengeId;

    public Regatta() {
    }

    public Regatta(Integer id) {
        this.id = id;
    }

    public Regatta(Integer id, String code, String name, Date date, float distance) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.date = date;
        this.distance = distance;
    }

//    public Regatta(JSONObject jsonObject) throws JSONException {
//        id = jsonObject.getInt("id");
//        code = jsonObject.getString("code");
//        name = jsonObject.getString("name");
//        date = new Date(jsonObject.getString("date"));
//        distance = jsonObject.getInt("distance");
//        JSONArray juries = jsonObject.getJSONArray("juryCollection");
//        for (int i = juries.length() -1; i >= 0; i--) {
//            juryCollection.add(new Jury(juries.getJSONObject(i)));
//        }
//        JSONArray auditors = jsonObject.getJSONArray("juryCollection");
//        for (int i = auditors.length() -1; i >= 0; i--) {
//            auditorCollection.add(new Auditor(auditors.getJSONObject(i)));
//        }
//        JSONArray competes = jsonObject.getJSONArray("competeCollection");
//        for (int i = competes.length() -1; i >= 0; i--) {
//            competeCollection.add(new Compete(competes.getJSONObject(i)));
//        }
//        challengeId = new Challenge(jsonObject.get("id"););
//    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Collection<Auditor> getAuditorCollection() {
        return auditorCollection;
    }

    public void setAuditorCollection(Collection<Auditor> auditorCollection) {
        this.auditorCollection = auditorCollection;
    }

    public Collection<Jury> getJuryCollection() {
        return juryCollection;
    }

    public void setJuryCollection(Collection<Jury> juryCollection) {
        this.juryCollection = juryCollection;
    }

    public Collection<Compete> getCompeteCollection() {
        return competeCollection;
    }

    public void setCompeteCollection(Collection<Compete> competeCollection) {
        this.competeCollection = competeCollection;
    }

    public Challenge getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Challenge challengeId) {
        this.challengeId = challengeId;
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
        if (!(object instanceof Regatta)) {
            return false;
        }
        Regatta other = (Regatta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "afpa.ecf.physicalregatta.model.Regatta[ id=" + id + " ]";
    }
    
}
