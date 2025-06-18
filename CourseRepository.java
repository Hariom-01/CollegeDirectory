package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
