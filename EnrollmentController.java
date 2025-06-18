package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.Enrollment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @GetMapping("/syntax")
    public Enrollment sendSyntax(){
        return new Enrollment();
    }

}
