# College Directory Application

## Overview

The College Directory Application is designed to manage student, faculty, and administrator profiles within a college, featuring role-based access control and CRUD operations for different user roles. Built with Spring Boot and Hibernate JPA for data persistence and secured using Spring Security, the application ensures a robust backend architecture. It also incorporates custom exception handling across all API endpoints to provide detailed error messages and efficient error management. To maintain data integrity, the application enforces various validations, including length constraints, not-null checks, and foreign key validations.
## Technologies Used

- **Backend**: Spring Boot, Hibernate JPA
- **Database**: PostgreSQL
- **Security**: Spring Security
- **Exception Handling**: Custom exceptions for detailed error messages

## Table Schema & Relationships

- **User Profiles**:
    - `StudentProfile`
    - `FacultyProfile`
    - `AdministratorProfile`
- **Other Tables**:
    - `Course`
    - `Enrollment`
    - `Department`

### On Delete Cascade

All foreign key relationships are set with cascading deletes to ensure that when a referenced entity is deleted, all associated records are also removed automatically.

## Functionalities

### Student Functionalities

- Fetch and display student profile details.
- Fetch and display faculty advisors' details related to a given student from the database.
- CRUD operations available to only **STUDENT** and **ADMINISTRATOR**.

### Faculty Member Functionalities

- Fetch and display class list from the database, showing all students taught by that faculty member.
- CRUD operations available to only **FACULTY_MEMBER** and **ADMINISTRATOR**.

### Administrator Functionalities

- CRUD operations for all the **STUDENT**, **FACULTY_MEMBER**, and **ADMINISTRATOR** roles.

## API Endpoints

### StudentProfile

- `GET /studentProfiles` – List all students.
- `POST /studentProfiles` – Create student.
- `PUT /studentProfiles/{id}` – Update a student using ID.
- `GET /studentProfiles/{id}` – Get a single student detail.
- `DELETE /studentProfiles/{id}` – Delete student using ID.
- `GET /studentProfiles/listFaculty/{id}` – List all faculties teaching that student.

### FacultyProfile

- `GET /facultyProfiles` – List all faculties.
- `POST /facultyProfiles` – Create faculty.
- `PUT /facultyProfiles/{id}` – Update a faculty using ID.
- `GET /facultyProfiles/{id}` – Get a single faculty detail.
- `DELETE /facultyProfiles/{id}` – Delete faculty using ID.
- `GET /facultyProfiles/listStudents/{id}` – List all students being taught by that faculty.

### AdministratorProfile

- `GET /administratorProfiles` – List all admins.
- `POST /administratorProfiles` – Create admin.
- `PUT /administratorProfiles/{id}` – Update an admin using ID.
- `GET /administratorProfiles/{id}` – Get a single admin detail.
- `DELETE /administratorProfiles/{id}` – Delete admin using ID.
- All endpoints present in **StudentProfile** and **FacultyProfile** are also available to **AdministratorProfile**.

## Validations & Constraints

- **Foreign Key Validation**: Implemented at the Spring level to check for foreign key constraints during data operations.
- **Length Constraints**: Applied where applicable to ensure data integrity.
- **Not Null Constraints**: Ensured required fields are not left empty.

## Exception Handling

- **Global Exception Handling**: All exceptions are handled globally to provide clean and informative error messages.
- **CustomEntityNotFoundException**: Thrown when a foreign key is not present.
- **HttpMessageNotReadableException**: Handles cases where POST data is invalid.
- **ConstraintViolationException**: Handles cases where constraints are violated.
- **MethodArgumentTypeMismatchException**: Handles bad URLs with incorrect argument types.
- **HttpRequestMethodNotSupportedException**: Handles incorrect HTTP methods used with valid URLs.

## Getting Started

1. **Clone the Repository**
   ```bash
   

2. **Set Up Database**
- Configure PostgreSQL and update application properties.

3. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
   
## Thank you for watching