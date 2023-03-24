package com.StudentRegistration.Controller;


import com.StudentRegistration.Service.StudentService;
import com.StudentRegistration.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/courses")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Course> retrieveCoursesForStudent(@PathVariable String studentId){

        return studentService.retrieveCourses(studentId);
    }

    @GetMapping("/{courseId}")
    public Course retrieveDetailsForCourse(@PathVariable String studentId, @PathVariable String courseId){

        return studentService.retrieveCourse(studentId,courseId);
    }

    @PostMapping()
    public ResponseEntity<Void> registerStudentForCourse (@PathVariable String studentId, @RequestBody Course newCourse){

        Course course = studentService.addCourse(studentId,newCourse);

        if(course == null){

            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course.id())
                .toUri();

        return ResponseEntity.created(location)
                .build();

    }

}
