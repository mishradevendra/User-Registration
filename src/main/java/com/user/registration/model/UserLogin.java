package com.user.registration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_login")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long loginId;
    private String userName;
    @NotEmpty
    @Size(min = 8, message = "password should have at least 8 characters")
   // @Pattern(regexp= "^[a-zA-Z0-9]")
    private String password;

}
