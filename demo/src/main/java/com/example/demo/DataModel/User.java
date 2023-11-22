package com.example.demo.DataModel;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userdetail")

public class User
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;



   private String name;

    @Column(name = "email",unique = true)
   private String email;

   private String password;

   @Column(name = "mobile_number")
   private Long mobileNumber;

   private  String university;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
