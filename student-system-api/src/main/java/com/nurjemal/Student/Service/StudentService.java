package com.nurjemal.Student.Service;

import com.nurjemal.Student.Entity.AdvisorEntity;
import com.nurjemal.Student.Entity.StudentEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findByDepartmentId(Long departmentId);

    ResponseEntity<StudentEntity> createStudentForSpecificDepartment(Long departmentId, StudentEntity studentRequest);


    ResponseEntity<StudentEntity> createStudentForSpecificAdvisor(Long advisorId, StudentEntity studentRequest);

    ResponseEntity<StudentEntity> createStudentForSpecificDepartmentAndAdvisor(Long departmentId, Long advisorId, StudentEntity studentRequest);

    List<StudentEntity> findByAdvisorId(Long advisorId);

    List<StudentEntity> fetchStudents();

    StudentEntity findStudentEntityById(Long studentId);

    StudentEntity updateStudentById(StudentEntity studentEntity);

    List<StudentEntity> findHighHonorStudents();

    List<StudentEntity> findStudentsByYear(Long enrollmentYear);

    List<StudentEntity> findStudentsByCGPA(Double cgpa);
}
