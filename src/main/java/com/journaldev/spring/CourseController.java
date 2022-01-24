package com.journaldev.spring;

import com.journaldev.spring.model.Course;
import com.journaldev.spring.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    public void setCourseService(CourseService ps){
        this.courseService = ps;
    }

    @RequestMapping(value = "/courses/getall", method = RequestMethod.GET,headers = "Accept=application/json")
    public List<Course> listCourses() {
      return courseService.listCourses();
    }


    @RequestMapping(value="/courses/getby_id/{id}",method = RequestMethod.GET,headers = "Accept=application/json")
    public Course getCourse(@PathVariable("id") int id){
       return courseService.getCourseById(id);
    }
}
