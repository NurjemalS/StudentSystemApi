package com.nurjemal.Student.Repository;

import com.nurjemal.Student.Entity.StudentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {


    List<StudentEntity> findStudentEntityByDepartment_DepartmentId(Long departmentId);
    List<StudentEntity> findStudentEntityByAdvisor_AdvisorId(Long advisorId);
    List<StudentEntity> findByCgpaGreaterThanEqual(Double cgpa);

    @Query("select s from StudentEntity s where s.enrollmentYear = :enrollmentYear")
    List<StudentEntity> findByStudentsByEnrollmentYearGiven(@Param("enrollmentYear") Long enrollmentYear);

    @Query("select s from StudentEntity s where s.cgpa > 3.50")
    List<StudentEntity> findHighHonorStudents();


}
