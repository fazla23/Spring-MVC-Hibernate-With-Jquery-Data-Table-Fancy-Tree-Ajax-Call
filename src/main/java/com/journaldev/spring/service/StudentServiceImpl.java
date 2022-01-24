package com.journaldev.spring.service;

import com.journaldev.spring.dao.StudentDAO;
import com.journaldev.spring.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO personDAO;

    public void setStudentDAO(StudentDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        return this.personDAO.listStudents();
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return this.personDAO.getStudentById(id);
    }

}
