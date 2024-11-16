package org.acme.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class ChildId implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "CMN_ID_1")
    private String commonId1;

    @NotNull
    @Column(name = "CMN_ID_2")
    private String commonId2;

    @NotNull
    @Column(name = "CMN_ID_3")
    private String commonId3;

    @NotNull
    @Column(name = "CHD_ID_4")
    private Integer childId4;

    /**
     * Construtor padrão necessário pelo JPA.
     */
    @Deprecated
    public ChildId() {
    }

    /**
     * Construtor completo para criação de chave composta.
     */
    public ChildId(@NotNull String commonId1, @NotNull String commonId2, @NotNull String commonId3,
                   @NotNull Integer childId4) {
        this.commonId1 = commonId1;
        this.commonId2 = commonId2;
        this.commonId3 = commonId3;
        this.childId4 = childId4;
    }

    public String getCommonId1() {
        return commonId1;
    }

    public void setCommonId1(String commonId1) {
        this.commonId1 = commonId1;
    }

    public String getCommonId2() {
        return commonId2;
    }

    public void setCommonId2(String commonId2) {
        this.commonId2 = commonId2;
    }

    public String getCommonId3() {
        return commonId3;
    }

    public void setCommonId3(String commonId3) {
        this.commonId3 = commonId3;
    }

    public Integer getChildId4() {
        return childId4;
    }

    public void setChildId4(Integer childId4) {
        this.childId4 = childId4;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commonId1, commonId2, commonId3, childId4);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ChildId other = (ChildId) obj;
        return Objects.equals(commonId1, other.commonId1) &&
               Objects.equals(commonId2, other.commonId2) &&
               Objects.equals(commonId3, other.commonId3) &&
               Objects.equals(childId4, other.childId4);
    }

    @Override
    public String toString() {
        return "ChildId [commonId1=" + commonId1 + ", commonId2=" + commonId2 + ", commonId3=" + commonId3
                + ", childId4=" + childId4 + "]";
    }

    
}
