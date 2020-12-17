package edu.miu.student.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "city should not be null")
    private String city;
    @NotBlank(message = "sate must not be null")
    private String sate;
    @NotBlank(message = "zip code should not be null")
    private String zipcode;
    public Adress() {
    }

//    public Adress(String city, String sate, String zipcode) {
//        this.city = city;
//        this.sate = sate;
//        this.zipcode = zipcode;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSate() {
        return sate;
    }

    public void setSate(String sate) {
        this.sate = sate;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", sate='" + sate + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
