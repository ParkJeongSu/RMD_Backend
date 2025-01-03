package com.jspark.rdmbackend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class State {
    @Id
    private String objectName;
    private String stateName;
    private String stateValue;
}
