package com.jspark.rdmbackend.dto;

import com.jspark.rdmbackend.entity.RmdColorSetKey;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RmdColorSetDto {
    private String typeName;
    private String stateName;
    private String stateValue;
    private String typeAttribute;
    private String typeAttributeValue;
}
