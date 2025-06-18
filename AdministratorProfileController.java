package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.dto.AdministratorProfileDTO;
import com.aryajohary.collegedirectory.dto.MapperUtil;
import com.aryajohary.collegedirectory.exceptions.CustomEntityNotFoundException;
import com.aryajohary.collegedirectory.repos.AdministratorProfileRepo;
import com.aryajohary.collegedirectory.repos.DepartmentRepo;
import com.aryajohary.collegedirectory.schemas.AdministratorProfile;
import com.aryajohary.collegedirectory.schemas.Department;
import com.aryajohary.collegedirectory.schemas.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administratorProfiles")
public class AdministratorProfileController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private AdministratorProfileRepo administratorProfileRepo;

    @GetMapping("/syntax")
    public AdministratorProfile sendSyntax(){
        return new AdministratorProfile();
    }

    @GetMapping("/{id}")
    public AdministratorProfile findById(@PathVariable int id){
        AdministratorProfile administratorProfile =  administratorProfileRepo.findById(id).orElse(null);
        if(administratorProfile==null){
            throw new CustomEntityNotFoundException("Can't find administrator with Id - "+id);
        }
        return administratorProfile;
    }

    @PostMapping
    public AdministratorProfile createAdministratorProfile(@RequestBody AdministratorProfileDTO administratorProfileDTO){
        Department department = departmentRepo.findById(administratorProfileDTO.getDepartmentId())
                .orElse(null);
        if(department==null){
            throw new CustomEntityNotFoundException("Department not found with Id "+administratorProfileDTO.getDepartmentId());
        }
        AdministratorProfile administratorProfile = new AdministratorProfile();
        MapperUtil.mapBaseProfileFields(administratorProfileDTO,administratorProfile);
        administratorProfile.setRole(Role.Administrator);
        administratorProfile.setDepartment(department);
        administratorProfile.setPhoto(administratorProfileDTO.getPhoto());

        return administratorProfileRepo.save(administratorProfile);
    }

    @PutMapping("/{id}")
    public AdministratorProfile updateAdministratorProfile(@PathVariable int id, @RequestBody AdministratorProfileDTO administratorProfileDTO){

        AdministratorProfile administratorProfile = administratorProfileRepo.findById(id).orElse(null);
        if(administratorProfile==null){
            throw new CustomEntityNotFoundException("Administrator not found with Id "+id);
        }

        Department department = departmentRepo.findById(administratorProfileDTO.getDepartmentId())
                .orElse(null);
        if(department==null){
            throw new CustomEntityNotFoundException("Department not found with Id "+administratorProfileDTO.getDepartmentId());
        }
        MapperUtil.mapBaseProfileFields(administratorProfileDTO,administratorProfile);
        administratorProfile.setDepartment(department);
        administratorProfile.setPhoto(administratorProfileDTO.getPhoto());

        return administratorProfileRepo.save(administratorProfile);
    }

}
