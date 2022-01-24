package com.journaldev.spring.model;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @Column(name="cid")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int cid;
    private String name;
    private String type;

//    @ManyToOne(targetEntity = Student.class,cascade = CascadeType.ALL)
//    private Student student;
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public Course(int cid, String name, String type) {
        this.cid = cid;
        this.name = name;
        this.type = type;
    }

    public Course() {

    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
