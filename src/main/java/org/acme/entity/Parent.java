package org.acme.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.acme.dto.Message;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARENT", schema = "SCHEMA1")
public class Parent implements Serializable {

    @EmbeddedId
    private ParentId id;

    @Column(name = "PAR_COL_1")
    private String parentColumn1;

    @Column(name = "PAR_COL_2")
    private String parentColumn2;

    @Column(name = "PAR_UDT")
    private LocalDateTime parentUpdate;

    //@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CMN_ID_1", referencedColumnName = "CMN_ID_1", insertable = false, updatable = false)
    @JoinColumn(name = "CMN_ID_2", referencedColumnName = "CMN_ID_2", insertable = false, updatable = false)
    @JoinColumn(name = "CMN_ID_3", referencedColumnName = "CMN_ID_3", insertable = false, updatable = false)
    private List<Child> children = new ArrayList<>();

    public static Parent buildFromMessage(Message message) {

        var parent = new Parent();
        parent.setId(new ParentId(message.getId1(), message.getId2(), message.getId3()));
        parent.setParentColumn1(message.getParent1());
        parent.setParentColumn2(message.getParent2());
        parent.setChildren(Child.buildFromMessage(message));
        parent.setParentUpdate(LocalDateTime.now());


        return parent;

    }

    public ParentId getId() {
        return id;
    }

    public void setId(ParentId id) {
        this.id = id;
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
        return "Parent [id=" + id + ", parentColumn1=" + parentColumn1 + ", parentColumn2=" + parentColumn2
                + ", parentUpdate=" + parentUpdate + ", children=" + children + "]";
    }

    

}
