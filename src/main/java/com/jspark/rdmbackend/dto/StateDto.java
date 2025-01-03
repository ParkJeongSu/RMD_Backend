package com.jspark.rdmbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateDto {
    private String objectName;
    private String stateName;
    private String stateValue;
}
