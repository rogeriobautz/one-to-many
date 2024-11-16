package org.acme.dto;

import java.util.List;

public class Message {

    private String id1;
    private String id2;
    private String id3;
    private String parent1;
    private String parent2;
    private List<String> children;

       
    public Message() {
    }
  
    public Message(String id1, String id2, String id3, String parent1, String parent2, List<String> children) {
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.children = children;
    }

    public String getId1() {
        return id1;
    }
    public void setId1(String id1) {
        this.id1 = id1;
    }
    public String getId2() {
        return id2;
    }
    public void setId2(String id2) {
        this.id2 = id2;
    }
    public String getId3() {
        return id3;
    }
    public void setId3(String id3) {
        this.id3 = id3;
    }
    public String getParent1() {
        return parent1;
    }
    public void setParent1(String parent1) {
        this.parent1 = parent1;
    }
    public String getParent2() {
        return parent2;
    }
    public void setParent2(String parent2) {
        this.parent2 = parent2;
    }
    public List<String> getChildren() {
        return children;
    }
    public void setChildren(List<String> children) {
        this.children = children;
    }
     

}
