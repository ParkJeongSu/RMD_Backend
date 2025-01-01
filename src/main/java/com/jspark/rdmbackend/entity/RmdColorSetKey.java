package com.jspark.rdmbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class RmdColorSetKey {

    @Column(name="typename")
    private String typeName;

    @Column(name="statename")
    private String stateName;

    @Column(name="statevalue")
    private String stateValue;

    @Column(name="typeattribute")
    private String typeAttribute;

    // 기본 생성자
    public RmdColorSetKey() {}

    public RmdColorSetKey(String typeName, String stateName, String stateValue , String typeAttribute) {
        if (typeName == null || stateName == null || stateValue == null || typeAttribute == null) {
            throw new IllegalArgumentException("None of the fields can be null");
        }
        this.typeName = typeName;
        this.stateName = stateName;
        this.stateValue = stateValue;
        this.typeAttribute = typeAttribute;
    }

    // equals()와 hashCode() 반드시 구현 (복합키 사용 시 필수)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RmdColorSetKey that = (RmdColorSetKey) o;

        if (!typeName.equals(that.typeName)) return false;
        if (!stateName.equals(that.stateName)) return false;
        if (!stateValue.equals(that.stateValue)) return false;
        return typeAttribute.equals(that.typeAttribute);
    }

    @Override
    public int hashCode() {
        int result = typeName.hashCode();
        result = 31 * result + stateName.hashCode();
        result = 31 * result + stateValue.hashCode();
        result = 31 * result + typeAttribute.hashCode();
        return result;
    }
}
