package edu.miu.student.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.time.LocalDate;
@Setter
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
   @NotEmpty(message = "city  should not be blank ")
    private String firstName;
    @NotBlank()
    @Size(min = 2,max = 8,message = "city  should not be between  2 and 8")
    private String lastName;
    //@NotBlank(message = "dateOfEmp  should not be blank ")
    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private LocalDate dateOfEmp;
    @NotBlank(message = "describition  should not be blank ")
    private String descripion;

   @Valid
   @OneToOne(cascade = CascadeType.ALL)
    private Address address;





}
