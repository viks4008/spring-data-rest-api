package org.jspider.springdatarestapi.service;

import org.jspider.springdatarestapi.model.Course;
import org.jspider.springdatarestapi.repository.CourseRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepositry repositry;

    public List<Course> getCourses(){
    List <Course> courses=repositry.findAll();
    return courses;
    }
    public Course getCoursesById(int id){
        return repositry.findById(id).orElse(null);
    }
    public void addNewCourse(Course c){
    repositry.save(c);
    }


    public void updateCourse(Course c){
        repositry.save(c);
    }

    public List<Course>  getAllCourse(){
        return repositry.findCourse();
    }
    public List<String>  getAllBatchCodes(){
        return repositry.getAllBatchCodes();
    }

    public List<Course> displayCourse(String subject){
        return repositry.displayCourse(subject);
    }
    public List<Course> test(String batch){
        return repositry.test(batch);
    }

    public List<Course> displayCourseContain() {
        return repositry.displayCourseContian();
    }
}
