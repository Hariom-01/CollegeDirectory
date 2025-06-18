package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.StudentProfileDTO;
import com.aryajohary.collegedirectory.dto.MapperUtil;
import com.aryajohary.collegedirectory.exceptions.CustomEntityNotFoundException;
import com.aryajohary.collegedirectory.repos.DepartmentRepo;
import com.aryajohary.collegedirectory.repos.StudentProfileRepo;
import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentProfiles")
public class StudentProfileController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private StudentProfileRepo studentProfileRepo;

    @GetMapping("/syntax")
    public StudentProfile sendSyntax(){
        return new StudentProfile();
    }

    @GetMapping
    public List<StudentProfile> findAll(){
        return studentProfileRepo.findAll();
    }

    @GetMapping("/{id}")
    public StudentProfile findById(@PathVariable int id){
        StudentProfile studentProfile =  studentProfileRepo.findById(id).orElse(null);
        if(studentProfile==null){
            throw new CustomEntityNotFoundException("Can't find student with Id - "+id);
        }
        return studentProfile;
    }

    @PostMapping
    public StudentProfile createStudentProfile(@RequestBody StudentProfileDTO studentProfileDTO){
        Department department = departmentRepo.findById(studentProfileDTO.getDepartmentId())
                .orElse(null);
        if(department==null){
            throw new CustomEntityNotFoundException("Department not found with Id "+studentProfileDTO.getDepartmentId());
        }
        StudentProfile studentProfile = new StudentProfile();
        MapperUtil.mapBaseProfileFields(studentProfileDTO,studentProfile);
        studentProfile.setDepartment(department);
        studentProfile.setPhoto(studentProfileDTO.getPhoto());
        studentProfile.setYear(studentProfileDTO.getYear());

        return studentProfileRepo.save(studentProfile);
    }

    @PutMapping("/{id}")
    public StudentProfile updateStudentProfile(@PathVariable int id, @RequestBody StudentProfileDTO studentProfileDTO){

        StudentProfile studentProfile = studentProfileRepo.findById(id).orElse(null);
        if(studentProfile==null){
            throw new CustomEntityNotFoundException("Student not found with Id "+id);
        }

        Department department = departmentRepo.findById(studentProfileDTO.getDepartmentId())
                .orElse(null);
        if(department==null){
            throw new CustomEntityNotFoundException("Department not found with Id "+studentProfileDTO.getDepartmentId());
        }
        MapperUtil.mapBaseProfileFields(studentProfileDTO,studentProfile);
        studentProfile.setRole(Role.Student);
        studentProfile.setDepartment(department);
        studentProfile.setPhoto(studentProfileDTO.getPhoto());
        studentProfile.setYear(studentProfileDTO.getYear());

        return studentProfileRepo.save(studentProfile);
    }

    @GetMapping("/{id}/facultyList")
    public List<FacultyProfile> getFacultyList(@PathVariable int id){
        return studentProfileRepo.getFacultyList(id);
    }

}
