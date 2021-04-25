package com.bluesky.model.destination;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uid;
    private String title;
    private String firstName;
    private String lastName;
    private String position;
    private String address;
    private String mobile;
    private String phone;
    private String email;
    private String companyName;

}
