package com.jspark.rdmbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Userprofile")
public class Userprofile {

    @Id
    @Column(name="username")
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(name="usertype",nullable = false)
    private String userType;
}
