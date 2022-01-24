package com.journaldev.spring.service;

import com.journaldev.spring.dao.CourseDAO;
import com.journaldev.spring.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseDAO personDAO;

    public void setCourseDAO(CourseDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public List<Course> listCourses() {
        return this.personDAO.listCourses();
    }

    @Override
    @Transactional
    public Course getCourseById(int id) {
        return this.personDAO.getCourseById(id);
    }

}
