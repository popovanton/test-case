package com.popovanton.testcase.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "test_case")
public class TestCase {

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

    @Column(name = "url")
    private String url;

    @Column(name = "orgid")
    private String orgid;

    @Column(name = "formid")
    private String formid;

    @Column(name = "code")
    private String code; // absent in actual Test case readme

    @Column(name = "ltpa")
    private String ltpa;

    @Column(name = "sudirresponse")
    private String sudirresponse;

    @Column(name = "ymdh")
    private String ymdh;

    public TestCase() {

    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirresponse() {
        return sudirresponse;
    }

    public void setSudirresponse(String sudirresponse) {
        this.sudirresponse = sudirresponse;
    }

    public String getYmdh() {
        return ymdh;
    }

    public void setYmdh(String ymdh) {
        this.ymdh = ymdh;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return ssoid.equals(testCase.ssoid) &&
                ts.equals(testCase.ts) &&
                grp.equals(testCase.grp) &&
                type.equals(testCase.type) &&
                subtype.equals(testCase.subtype) &&
                url.equals(testCase.url) &&
                orgid.equals(testCase.orgid) &&
                formid.equals(testCase.formid) &&
                Objects.equals(code, testCase.code) &&
                Objects.equals(ltpa, testCase.ltpa) &&
                Objects.equals(sudirresponse, testCase.sudirresponse) &&
                ymdh.equals(testCase.ymdh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssoid, ts, grp, type, subtype, url, orgid, formid, code, ltpa, sudirresponse, ymdh);
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "ssoid='" + ssoid + '\'' +
                ", ts=" + ts +
                ", grp='" + grp + '\'' +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                ", url='" + url + '\'' +
                ", orgid='" + orgid + '\'' +
                ", formid='" + formid + '\'' +
                ", code='" + code + '\'' +
                ", ltpa='" + ltpa + '\'' +
                ", sudirresponse='" + sudirresponse + '\'' +
                ", ymdh=" + ymdh +
                '}';
    }
}
