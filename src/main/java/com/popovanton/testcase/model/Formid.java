package com.popovanton.testcase.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "formid")
public class Formid {

    @Id
    @Column(name = "formid")
    private String formid;

    @Column(name = "count")
    private Long count;

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formid formid1 = (Formid) o;
        return count == formid1.count &&
                Objects.equals(formid, formid1.formid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formid, count);
    }
}

