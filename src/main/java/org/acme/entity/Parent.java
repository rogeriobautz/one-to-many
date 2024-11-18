package org.acme.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.acme.dto.Message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARENT", schema = "SCHEMA1")
@IdClass(ParentId.class)
@Data
@ToString
public class Parent implements Serializable {

    @Id
    @Column(name = "COMMON_ID_1")
    private String commonId1;

    @Id
    @Column(name = "COMMON_ID_2")
    private String commonId2;

    @Id
    @Column(name = "COMMON_ID_3")
    private String commonId3;

    @Column(name = "PARENT_COLUMN_1")
    private String parentColumn1;

    @Column(name = "PARENT_COLUMN_2")
    private String parentColumn2;

    @Column(name = "PARENT_UPDATE")
    private LocalDateTime parentUpdate;

    //@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "COMMON_ID_1", referencedColumnName = "COMMON_ID_1", insertable = false, updatable = false)
    @JoinColumn(name = "COMMON_ID_2", referencedColumnName = "COMMON_ID_2", insertable = false, updatable = false)
    @JoinColumn(name = "COMMON_ID_3", referencedColumnName = "COMMON_ID_3", insertable = false, updatable = false)
    private List<Child> children = new ArrayList<>();

    public static Parent buildFromMessage(Message message) {
        var parent = new Parent();
        parent.setCommonId1(message.getId1());
        parent.setCommonId2(message.getId2());
        parent.setCommonId3(message.getId3());
        parent.setParentColumn1(message.getParent1());
        parent.setParentColumn2(message.getParent2());
        parent.setChildren(Child.buildFromMessage(message));
        parent.setParentUpdate(LocalDateTime.now());

        return parent;
    }
}
