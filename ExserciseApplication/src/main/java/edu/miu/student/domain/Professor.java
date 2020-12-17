package edu.miu.student.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "name should not be blank")
    private String name;
    @NotBlank(message = "blank is not allwoed")
    private String lasname;
    //@NotBlank()
   // @Size(min = 2,max = 8,message = "city  should not be between  2 and 8")
    @NotNull(message = "make not null")
    private int age;
    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private LocalDate birthdate;
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Adress adress;
//    @NotNull
//    @OneToMany(cascade = CascadeType.ALL)
//    //@JoinColumn(name = "Pro_phone")
//    private List<Phone> phone;
    public Professor() {
    }

//    public Professor(Long id, @NotBlank(message = "name should not be blank") String name, @NotBlank(message = "blank is not allwoed") String lasname, @NotNull(message = "make not null") int age, LocalDate birthdate, Adress adress) {
//        this.id = id;
//        this.name = name;
//        this.lasname = lasname;
//        this.age = age;
//        this.birthdate = birthdate;
//        this.adress = adress;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLasname() {
        return lasname;
    }

    public void setLasname(String lasname) {
        this.lasname = lasname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

//    public List<Phone> getPhone() {
//        return phone;
//    }
//
//    public void setPhone(List<Phone> phone) {
//        this.phone = phone;
//    }


    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lasname='" + lasname + '\'' +
                ", age=" + age +
                ", birthdate=" + birthdate +
                ", adress=" + adress +
                '}';
    }
}
