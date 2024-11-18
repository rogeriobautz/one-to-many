package org.acme.entity;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
public class ParentId implements Serializable {

    private String commonId1;
    private String commonId2;
    private String commonId3;

    public ParentId(@NotNull String commonId1, @NotNull String commonId2, @NotNull String commonId3) {
        this.commonId1 = commonId1;
        this.commonId2 = commonId2;
        this.commonId3 = commonId3;
    }
}
