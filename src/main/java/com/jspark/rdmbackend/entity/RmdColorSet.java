package com.jspark.rdmbackend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rmdcolorset")
public class RmdColorSet {

    @EmbeddedId
    private RmdColorSetKey key;

    @Column(name="typeattributevalue")
    private String typeAttributeValue;
}
