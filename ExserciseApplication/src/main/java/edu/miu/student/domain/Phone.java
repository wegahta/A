package edu.miu.student.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String areacode;
    private String prefix;
    private String sufix;


    public Phone() {
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSufix(String number) {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix = sufix;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public Long getId() {
        return id;
    }

//    @Override
//    public String toString() {
//        return "Phone{" +
//                "id=" + id +
//                ", prefix='" + prefix + '\'' +
//                ", sufix='" + sufix + '\'' +
//                ", areacode='" + areacode + '\'' +
//                '}';
//    }
}
