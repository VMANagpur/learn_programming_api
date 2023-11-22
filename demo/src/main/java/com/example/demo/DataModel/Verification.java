package com.example.demo.DataModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "verification_email")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String verificationtoken;

    private Boolean isenable;


    @OneToOne (targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user_id;

    public String getVerificationtoken() {
        return verificationtoken;
    }

    public void setVerificationtoken(String verificationtoken) {
        this.verificationtoken = verificationtoken;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
