package com.aryajohary.collegedirectory.repos;

import com.aryajohary.collegedirectory.schemas.FacultyProfile;
import com.aryajohary.collegedirectory.schemas.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacultyProfileRepo extends JpaRepository<FacultyProfile, Integer> {

    @Query("select s " +
            "from Enrollment e " +
            "join e.studentProfile s " +
            "join e.course c " +
            "join c.facultyProfile f " +
            "where f.id = :facultyId"
    )
    List<StudentProfile> getStudentList(@Param("facultyId") int facultyId);

}
