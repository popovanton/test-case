package com.popovanton.testcase.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "test_case")
public class OneHourActivityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ssoid")
    private String ssoid;

    @Column(name = "ts")
    private String ts;

    @Column(name = "formid")
    private String formid;


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
        OneHourActivityUser that = (OneHourActivityUser) o;
        return  Objects.equals(ssoid, that.ssoid) &&
                Objects.equals(ts, that.ts) &&
                Objects.equals(formid, that.formid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssoid, ts, formid);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
