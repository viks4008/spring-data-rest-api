package org.jspider.springdatarestapi.repository;

import org.jspider.springdatarestapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepositry extends JpaRepository<Course,Integer> {

    // select all courses
    @Query("select c from Course c")
    List<Course> findCourse();

    // select all courses BatchCode
    @Query("select c.batchCode from Course c")
    List<String> getAllBatchCodes();

    // find course detail by subject
    @Query("select c from Course c where c.subject=:subject")
    List<Course> displayCourse(@Param(value = "subject") String subject);

    // Find all course in which subject name conatin a
    @Query(value = "select * from course_info where subject like '%A' ;",nativeQuery = true)
    List<Course> displayCourseContian();


    // Find all course in which batch code contains specified characters(aacept value from user)
    @Query("select c from Course c where c.batchCode like %:batch%")
    List<Course> test(@Param(value = "batch") String batch);

}
