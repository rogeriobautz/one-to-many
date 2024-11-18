package org.acme.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class ParentId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "COMMON_ID_1")
    private String commonId1;

    @Column(name = "COMMON_ID_2")
    private String commonId2;

    @Column(name = "COMMON_ID_3")
    private String commonId3;

    public ParentId() {
    }

    public ParentId(@NotNull String commonId1, @NotNull String commonId2, @NotNull String commonId3) {
        this.commonId1 = commonId1;
        this.commonId2 = commonId2;
        this.commonId3 = commonId3;
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



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((commonId1 == null) ? 0 : commonId1.hashCode());
        result = prime * result + ((commonId2 == null) ? 0 : commonId2.hashCode());
        result = prime * result + ((commonId3 == null) ? 0 : commonId3.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ParentId other = (ParentId) obj;
        if (commonId1 == null) {
            if (other.commonId1 != null)
                return false;
        } else if (!commonId1.equals(other.commonId1))
            return false;
        if (commonId2 == null) {
            if (other.commonId2 != null)
                return false;
        } else if (!commonId2.equals(other.commonId2))
            return false;
        if (commonId3 == null) {
            if (other.commonId3 != null)
                return false;
        } else if (!commonId3.equals(other.commonId3))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ParentId [commonId1=" + commonId1 + ", commonId2=" + commonId2 + ", commonId3=" + commonId3 + "]";
    }

    
}
