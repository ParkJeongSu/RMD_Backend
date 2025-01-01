package com.jspark.rdmbackend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rmdfactory")
public class RmdFactory {

    @Id
    @Column(name="factoryname")
    private String factoryName;

    @Column(name="defaultfactoryflag")
    private String defaultFactoryFlag;

    @Column(name="position")
    private String position;
}
