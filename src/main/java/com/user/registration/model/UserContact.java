package com.user.registration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_contact")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserContact {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long contactId;
    @NotEmpty
    @Size(min = 10, max = 12, message = "Contact no should have at least 10 characters")
    private String contact;
    @NotEmpty (message = "Address should not be empty!")
    private String address;

}
