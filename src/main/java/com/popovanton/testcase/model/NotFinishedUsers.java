package com.popovanton.testcase.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "not_finished")
public class NotFinishedUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ssoid")
    private String ssoid;

    @Column(name = "ts")
    private String ts;

    @Column(name = "grp")
    private String grp;

    @Column(name = "type")
    private String type;

    @Column(name = "subtype")
    private String subtype;

    @Column(name = "orgid")
    private String orgid;

    @Column(name = "formid")
    private String formid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotFinishedUsers that = (NotFinishedUsers) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ssoid, that.ssoid) &&
                Objects.equals(ts, that.ts) &&
                Objects.equals(grp, that.grp) &&
                Objects.equals(type, that.type) &&
                Objects.equals(subtype, that.subtype) &&
                Objects.equals(orgid, that.orgid) &&
                Objects.equals(formid, that.formid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ssoid, ts, grp, type, subtype, orgid, formid);
    }
}
