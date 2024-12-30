package com.jspark.rdmbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Userprofile")
public class Userprofile {

    @Id
    @Column(name="userid")
    private String userId;

    @Column(name="username",nullable = false)
    private String userName;

    @Column(name="usergroupname")
    private String userGroupName;

    @Column(nullable = false)
    private String password;

    @Column(name="department")
    private String department;

    @Column(name="phonenumber")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="localename")
    private String localeName;

    @Column(name="lastlogintime")
    private Timestamp lastLoginTime;

    @Column(name="lastpasswordtime")
    private Timestamp lastPasswordTime;

    @Column(name="validflag")
    private String validFlag;

    @Column(name="fmbdefaultfactoryname")
    private String fmbDefaultFactoryName;

    @Column(name="lasteventcomment")
    private String lastEventComment;
}
