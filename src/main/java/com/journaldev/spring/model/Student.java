package com.journaldev.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(name="sid")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int sid;
    private String name;
    private String roll;

//    @OneToMany(mappedBy = "student",cascade = CascadeType.MERGE)
//    private List<Course> courseList;

    @OneToMany(targetEntity = Course.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "sid",referencedColumnName = "sid")
    private List<Course> courseList;

    public Student(int sid, String name, String roll) {
        this.sid = sid;
        this.name = name;
        this.roll = roll;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Student() {

    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
