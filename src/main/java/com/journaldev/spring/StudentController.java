package com.journaldev.spring;

import com.journaldev.spring.model.Course;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Student;
import com.journaldev.spring.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

@RestController
public class StudentController {

    private StudentService studentService;

    public void setStudentService(StudentService ps){
        this.studentService = ps;
    }


    @RequestMapping(value = "/students/getall", method = RequestMethod.GET)
    public List<Student> listStudents() {
        List<Student> students = new ArrayList<Student>();
        students =studentService.listStudents();
        System.out.println(students);
        return studentService.listStudents();
    }

    @RequestMapping(value = "/students/tree", method = RequestMethod.GET)
    public List<Object> students() {

        List<Object> finalResponse = new ArrayList<Object>();
        List<Object> jsonListOfStudents = new ArrayList<Object>();
        List<Student> students;
        students =studentService.listStudents();
        int i=1;
        for(Student student:students){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("key",i+1);
            jsonObject.put("title",student.getName());
            List<Course> courseList = student.getCourseList();
            List<Object> courseListJson = new ArrayList<Object>();

            int j=0;
            if (!courseList.isEmpty()){
            for (Course course:courseList){
                JSONObject jsonObjectCourse = new JSONObject();
                jsonObjectCourse.put("key",(i+1)+"_"+(j+1));
                jsonObjectCourse.put("title",course.getName());
                courseListJson.add(jsonObjectCourse);
                j++;
            }
            jsonObject.put("folder",true);
            jsonObject.put("children",courseListJson);
            }
            else{
                jsonObject.put("folder", false);
            }
            jsonListOfStudents.add(jsonObject);
            i++;
        }
        JSONObject jo = new JSONObject();
        jo.put("key",1);
        jo.put("title","Students");
        jo.put("folder",true);
        jo.put("children",jsonListOfStudents);

        finalResponse.add(jo);
        return finalResponse;
    }


    @RequestMapping(value="/students/getby_id/{id}",method = RequestMethod.GET,headers = "Accept=application/json")
    public Student getStudent(@PathVariable("id") int id){
      return studentService.getStudentById(id);
    }
}
