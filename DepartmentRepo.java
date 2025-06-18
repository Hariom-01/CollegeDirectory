package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
}
