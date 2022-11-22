package com.user.registration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="user_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;
    @NotEmpty
    @Size(min = 3, max = 16, message = "User name should not have less than 3 and greater than 16 characters!")
   // @Pattern(regexp= "[^0-9]*")
    private String name;
    @NotEmpty
    @Email(message = "Email should be valid!")
    private String email;
    private String gender;
    private Long age;
    private Long salary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_Id")
    private List<UserContact> userContact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loginId")
    private UserLogin userLogin;

}
