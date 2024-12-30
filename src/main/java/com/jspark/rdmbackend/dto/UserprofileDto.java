package com.jspark.rdmbackend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class UserprofileDto {
    private String userId;
    private String userName;
    private String userGroupName;
    private String password;
    private String department;
    private String phoneNumber;
    private String email;
    private String localeName;
    private Timestamp lastLoginTime;
    private Timestamp lastPasswordTime;
    private String validFlag;
    private String fmbDefaultFactoryName;
    private String lastEventComment;
}