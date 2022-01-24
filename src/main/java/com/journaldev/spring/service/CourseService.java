package com.journaldev.spring.service;

import com.journaldev.spring.model.Course;

import java.util.List;

public interface CourseService {

    //public void addCourse(Course p);
   // public void updateCourse(Course p);
    public List<Course> listCourses();
    public Course getCourseById(int id);
    //public void removeCourse(int id);

}
