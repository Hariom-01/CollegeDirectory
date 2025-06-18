package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping("/syntax")
    public Course sendSyntax(){
        return new Course();
    }

}
