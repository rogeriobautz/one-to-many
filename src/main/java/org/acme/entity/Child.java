package org.acme.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.acme.dto.Message;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHILD", schema = "SCHEMA1")
public class Child implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ChildId id;

    @Column(name = "CHD_COL_1")
    private String childColumn1;

    @Column(name = "CHD_UDT")
    private LocalDateTime   childUpdate;

    // @ManyToOne()
    // @JoinColumn(name = "CMN_ID_1", referencedColumnName = "CMN_ID_1")
    // @JoinColumn(name = "CMN_ID_2", referencedColumnName = "CMN_ID_2")
    // @JoinColumn(name = "CMN_ID_3", referencedColumnName = "CMN_ID_3")
    // private Parent parent;

    public static List<Child> buildFromMessage(Message message) {
        if (message.getChildren().isEmpty()) {
            return Collections.emptyList();
        }

        var children = new ArrayList<Child>();
        int index = 0;
        for (var childDto : message.getChildren()) {
            var child = new Child();
            child.setId(new ChildId(message.getId1(), message.getId2(), message.getId3(), index));
            child.setChildColumn1(childDto);
            child.setChildUpdate(LocalDateTime.now());
            children.add(child);
            index++;
        }
        return children;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ChildId getId() {
        return id;
    }

    public void setId(ChildId id) {
        this.id = id;
    }

    public String getChildColumn1() {
        return childColumn1;
    }

    public void setChildColumn1(String childColumn1) {
        this.childColumn1 = childColumn1;
    }

    public LocalDateTime getChildUpdate() {
        return childUpdate;
    }

    public void setChildUpdate(LocalDateTime childUpdate) {
        this.childUpdate = childUpdate;
    }

    @Override
    public String toString() {
        return "Child [id=" + id + ", childColumn1=" + childColumn1 + ", childUpdate=" + childUpdate + "]";
    }

    // public Parent getParent() {
    //     return parent;
    // }

    // public void setParent(Parent parent) {
    //     this.parent = parent;
    // }
    
}
