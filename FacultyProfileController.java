package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.FacultyProfileDTO;
import com.aryajohary.collegedirectory.dto.MapperUtil;
import com.aryajohary.collegedirectory.exceptions.CustomEntityNotFoundException;
import com.aryajohary.collegedirectory.repos.DepartmentRepo;
import com.aryajohary.collegedirectory.repos.FacultyProfileRepo;
import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.Role;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facultyProfiles")
public class FacultyProfileController {

    @Autowired
    private FacultyProfileRepo facultyProfileRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping("/syntax")
    public FacultyProfile sendSyntax(){
        return new FacultyProfile();
    }

    @GetMapping
    public List<FacultyProfile> findAll(){
        return facultyProfileRepo.findAll();
    }

    @GetMapping("/{id}")
    public FacultyProfile findById(@PathVariable int id){
        FacultyProfile facultyProfile =  facultyProfileRepo.findById(id).orElse(null);
        if(facultyProfile==null){
            throw new CustomEntityNotFoundException("Can't find faculty with Id - "+id);
        }
        return facultyProfile;
    }

    @PostMapping
    public FacultyProfile createFacultyProfile(@RequestBody FacultyProfileDTO facultyProfileDTO){
        Department department = departmentRepo.findById(facultyProfileDTO.getDepartmentId())
                .orElse(null);
        if(department==null){
            throw new CustomEntityNotFoundException("Department not found with Id "+facultyProfileDTO.getDepartmentId());
        }
        FacultyProfile facultyProfile = new FacultyProfile();
        MapperUtil.mapBaseProfileFields(facultyProfileDTO,facultyProfile);
        facultyProfile.setRole(Role.Faculty_Member);
        facultyProfile.setDepartment(department);
        facultyProfile.setPhoto(facultyProfileDTO.getPhoto());
        facultyProfile.setOfficeHours(facultyProfileDTO.getOfficeHours());

        return facultyProfileRepo.save(facultyProfile);
    }

    @PutMapping("/{id}")
    public FacultyProfile updateFacultyProfile(@PathVariable int id, @RequestBody FacultyProfileDTO facultyProfileDTO){

        FacultyProfile facultyProfile = facultyProfileRepo.findById(id).orElse(null);
        if(facultyProfile==null){
            throw new CustomEntityNotFoundException("Faculty not found with Id "+id);
        }

        Department department = departmentRepo.findById(facultyProfileDTO.getDepartmentId())
                .orElse(null);
        if(department==null){
            throw new CustomEntityNotFoundException("Department not found with Id "+facultyProfileDTO.getDepartmentId());
        }
        MapperUtil.mapBaseProfileFields(facultyProfileDTO,facultyProfile);
        facultyProfile.setDepartment(department);
        facultyProfile.setPhoto(facultyProfileDTO.getPhoto());
        facultyProfile.setOfficeHours(facultyProfileDTO.getOfficeHours());

        return facultyProfileRepo.save(facultyProfile);
    }


    @GetMapping("{id}/studentsList")
    public List<StudentProfile> getStudentList(@PathVariable int id){
        return facultyProfileRepo.getStudentList(id);
    }

}
