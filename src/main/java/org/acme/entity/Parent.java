package org.acme.entity;

import jakarta.persistence.*;
import org.acme.dto.Message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARENT", schema = "SCHEMA1")
@IdClass(ParentId.class)
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

    public String getParentColumn1() {
        return parentColumn1;
    }

    public void setParentColumn1(String parentColumn1) {
        this.parentColumn1 = parentColumn1;
    }

    public String getParentColumn2() {
        return parentColumn2;
    }

    public void setParentColumn2(String parentColumn2) {
        this.parentColumn2 = parentColumn2;
    }

    public LocalDateTime getParentUpdate() {
        return parentUpdate;
    }

    public void setParentUpdate(LocalDateTime parentUpdate) {
        this.parentUpdate = parentUpdate;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Parent [commonId1=" + commonId1 + ", commonId2=" + commonId2 + ", commonId3=" + commonId3 + ", parentColumn1=" + parentColumn1 + ", parentColumn2=" + parentColumn2
                + ", parentUpdate=" + parentUpdate + ", children=" + children + "]";
    }

    

}
