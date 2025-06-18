package com.aryajohary.collegedirectory;

import com.aryajohary.collegedirectory.repos.*;
import com.aryajohary.collegedirectory.schemas.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private StudentProfileRepo studentProfileRepo;

    @Autowired
    private FacultyProfileRepo facultyProfileRepo;

    @Autowired
    private AdministratorProfileRepo administratorProfileRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    private List<Department> createDepartments() {
        Department csDepartment = new Department("Computer Science", "Department of Computer Science");
        Department mathDepartment = new Department("Mathematics", "Department of Mathematics");
        Department physicsDepartment = new Department("Physics", "Department of Physics");
        Department chemistryDepartment = new Department("Chemistry", "Department of Chemistry");
        Department biologyDepartment = new Department("Biology", "Department of Biology");
        Department economicsDepartment = new Department("Economics", "Department of Economics");

        return List.of(csDepartment, mathDepartment, physicsDepartment, chemistryDepartment, biologyDepartment, economicsDepartment);
    }

    private List<StudentProfile> createStudentProfiles(List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department mathDepartment = departments.get(1);
        Department biologyDepartment = departments.get(4);
        Department economicsDepartment = departments.get(5);

        StudentProfile studentProfile1 = new StudentProfile(
                "arya_student1", "password123", "Arya Student 1", "student1@college.com", "123-456-7890",
                "https://example.com/photos/arya_student1.jpg", "2", csDepartment);

        StudentProfile studentProfile2 = new StudentProfile(
                "arya_student2", "password456", "Arya Student 2", "student2@college.com", "987-654-3210",
                "https://example.com/photos/arya_student2.jpg", "3", biologyDepartment);

        StudentProfile studentProfile3 = new StudentProfile(
                "arya_student3", "password789", "Arya Student 3", "student3@college.com", "456-123-7890",
                "https://example.com/photos/arya_student3.jpg", "1", economicsDepartment);

        StudentProfile studentProfile4 = new StudentProfile(
                "arya_student4", "password001", "Arya Student 4", "student4@college.com", "789-012-3456",
                "https://example.com/photos/arya_student4.jpg", "4", mathDepartment);

        StudentProfile studentProfile5 = new StudentProfile(
                "arya_student5", "password002", "Arya Student 5", "student5@college.com", "012-345-6789",
                "https://example.com/photos/arya_student5.jpg", "3", csDepartment);

        return List.of(studentProfile1, studentProfile2, studentProfile3, studentProfile4, studentProfile5);
    }

    private List<FacultyProfile> createFacultyProfiles(List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department chemistryDepartment = departments.get(3);
        Department economicsDepartment = departments.get(5);

        FacultyProfile facultyProfile1 = new FacultyProfile(
                "arya_faculty1", "password123", "Arya Faculty 1", "faculty1@college.com", "123-456-7890",
                "https://example.com/photos/arya_faculty1.jpg", chemistryDepartment, "9 AM - 5 PM");

        FacultyProfile facultyProfile2 = new FacultyProfile(
                "arya_faculty2", "password456", "Arya Faculty 2", "faculty2@college.com", "234-567-8901",
                "https://example.com/photos/arya_faculty2.jpg", csDepartment, "10 AM - 6 PM");

        FacultyProfile facultyProfile3 = new FacultyProfile(
                "arya_faculty3", "password789", "Arya Faculty 3", "faculty3@college.com", "345-678-9012",
                "https://example.com/photos/arya_faculty3.jpg", economicsDepartment, "8 AM - 4 PM");

        FacultyProfile facultyProfile4 = new FacultyProfile(
                "arya_faculty4", "password101", "Arya Faculty 4", "faculty4@college.com", "456-789-0123",
                "https://example.com/photos/arya_faculty4.jpg", chemistryDepartment, "9 AM - 2 PM");

        return List.of(facultyProfile1, facultyProfile2, facultyProfile3, facultyProfile4);
    }

    private List<AdministratorProfile> createAdministratorProfiles(List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department physicsDepartment = departments.get(2);
        Department economicsDepartment = departments.get(5);

        AdministratorProfile adminProfile1 = new AdministratorProfile(
                "admin1", "adminpass1", "Admin 1", "admin1@college.com", "123-456-7890",
                "https://example.com/photos/admin1.jpg", csDepartment);

        AdministratorProfile adminProfile2 = new AdministratorProfile(
                "admin2", "adminpass2", "Admin 2", "admin2@college.com", "234-567-8901",
                "https://example.com/photos/admin2.jpg", physicsDepartment);

        AdministratorProfile adminProfile3 = new AdministratorProfile(
                "admin3", "adminpass3", "Admin 3", "admin3@college.com", "345-678-9012",
                "https://example.com/photos/admin3.jpg", economicsDepartment);

        return List.of(adminProfile1, adminProfile2, adminProfile3);
    }

    private List<Course> createCourses(List<FacultyProfile> facultyProfiles, List<Department> departments) {
        Department csDepartment = departments.get(0);
        Department mathDepartment = departments.get(1);
        Department chemistryDepartment = departments.get(3);
        Department biologyDepartment = departments.get(4);
        Department economicsDepartment = departments.get(5);

        FacultyProfile facultyProfile1 = facultyProfiles.get(1);
        FacultyProfile facultyProfile2 = facultyProfiles.get(0);
        FacultyProfile facultyProfile3 = facultyProfiles.get(2);

        Course course1 = new Course(
                "Advanced Programming", "Advanced concepts in programming languages", csDepartment, facultyProfile1);

        Course course2 = new Course(
                "Calculus II", "Advanced calculus covering differential equations", mathDepartment, facultyProfile2);

        Course course3 = new Course(
                "Chemical Bonding", "Deep dive into molecular structures and bonding", chemistryDepartment, facultyProfile2);

        Course course4 = new Course(
                "Microeconomics", "Study of individual decision-making and market interactions", economicsDepartment, facultyProfile3);

        Course course5 = new Course(
                "Genetics", "Study of genes, genetic variation, and heredity in living organisms", biologyDepartment, facultyProfile2);

        return List.of(course1, course2, course3, course4, course5);
    }

    private List<Enrollment> createEnrollments(List<StudentProfile> students, List<Course> courses) {
        Enrollment enrollment1 = new Enrollment(students.get(0), courses.get(0));  // student 1 -> Advanced Programming
        Enrollment enrollment2 = new Enrollment(students.get(1), courses.get(4));  // student 2 -> Genetics
        Enrollment enrollment3 = new Enrollment(students.get(2), courses.get(3));  // student 3 -> Microeconomics
        Enrollment enrollment4 = new Enrollment(students.get(3), courses.get(1));  // student 4 -> Calculus II
        Enrollment enrollment5 = new Enrollment(students.get(4), courses.get(2)); // student 5 -> Chemical Bonding
        Enrollment enrollment6 = new Enrollment(students.get(1), courses.get(0)); // student 2 -> Advanced Programming
        Enrollment enrollment7 = new Enrollment(students.get(3), courses.get(3)); // student 4 -> Microeconomics
        Enrollment enrollment8 = new Enrollment(students.get(0), courses.get(4)); // student 1 -> Genetics
        Enrollment enrollment9 = new Enrollment(students.get(2), courses.get(2)); // student 3 -> Chemical Bonding
        Enrollment enrollment10 = new Enrollment(students.get(4), courses.get(1)); // student 5 -> Calculus II

        return List.of(enrollment1, enrollment2, enrollment3, enrollment4, enrollment5, enrollment6, enrollment7, enrollment8, enrollment9, enrollment10);
    }

    // main method to create the complex college records
    @PostConstruct
    private void createComplexCollegeRecords() {
        List<Department> departments = createDepartments();
        departmentRepo.saveAll(departments);

        List<StudentProfile> students = createStudentProfiles(departments);
        studentProfileRepo.saveAll(students);

        List<FacultyProfile> facultyProfiles = createFacultyProfiles(departments);
        facultyProfileRepo.saveAll(facultyProfiles);

        List<AdministratorProfile> administrators = createAdministratorProfiles(departments);
        administratorProfileRepo.saveAll(administrators);

        List<Course> courses = createCourses(facultyProfiles, departments);
        courseRepo.saveAll(courses);

        List<Enrollment> enrollments = createEnrollments(students, courses);
        enrollmentRepo.saveAll(enrollments);
    }
}