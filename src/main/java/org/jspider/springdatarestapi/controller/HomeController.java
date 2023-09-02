package org.jspider.springdatarestapi.controller;

import org.jspider.springdatarestapi.model.Course;
import org.jspider.springdatarestapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private CourseService service;

    @GetMapping("/courses")
    public List<Course> getCourse(){
        return service.getCourses();
    }
    @PostMapping("/courses")
    public  void addNewCourse(@RequestBody Course c){
        service.addNewCourse(c);
    }

    public Course getCourseById(@RequestBody int id){
        return service.getCoursesById(id);
    }

    @GetMapping("/getallcourse")
    public List<Course> getAllCourse(){
        return service.getAllCourse();
    }
    @GetMapping("/getallbatchcode")
    public List<String> getAllBatchCodes(){
     return service.getAllBatchCodes();
    }

    @GetMapping("/displaycourse/{subject}")
    public List<Course> displayCourse(@PathVariable(value = "subject") String subject){
        return service.displayCourse(subject);
    }

    @GetMapping("/displaycoursecontain")
    public List<Course> displayCourseContain(){
        return service.displayCourseContain();
    }

    @GetMapping("/displaybybatch/{batch}")
    public List<Course> test(@PathVariable String batch){
        return service.test(batch);
    }
}
