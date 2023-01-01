package com.nurjemal.Student.Service;

import com.nurjemal.Student.Entity.AdvisorEntity;
import com.nurjemal.Student.Entity.DepartmentEntity;
import com.nurjemal.Student.Entity.StudentEntity;
import com.nurjemal.Student.Repository.AdvisorRepository;
import com.nurjemal.Student.Repository.DepartmentRepository;
import com.nurjemal.Student.Repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;
    private AdvisorRepository advisorRepository;

    public StudentServiceImpl(StudentRepository studentRepository, DepartmentRepository departmentRepository, AdvisorRepository advisorRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.advisorRepository = advisorRepository;
    }

    @Override
    public List<StudentEntity> findByDepartmentId(Long departmentId) {
        List<StudentEntity> studentEntities = studentRepository.findStudentEntityByDepartment_DepartmentId(departmentId);
        return studentEntities;
    }

    @Override
    public ResponseEntity<StudentEntity> createStudentForSpecificDepartment(Long departmentId, StudentEntity studentRequest) {
        DepartmentEntity department = departmentRepository.findById(departmentId).get();
        studentRequest.setDepartment(department);
        studentRepository.save(studentRequest);
        return new ResponseEntity<>(studentRequest, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<StudentEntity> createStudentForSpecificAdvisor(Long advisorId, StudentEntity studentRequest) {
        AdvisorEntity advisor = advisorRepository.findById(advisorId).get();
        studentRequest.setAdvisor(advisor);
        studentRepository.save(studentRequest);
        return new ResponseEntity<>(studentRequest, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<StudentEntity> createStudentForSpecificDepartmentAndAdvisor(Long departmentId, Long advisorId, StudentEntity studentRequest) {
        DepartmentEntity department = departmentRepository.findById(departmentId).get();
        studentRequest.setDepartment(department);
        AdvisorEntity advisor = advisorRepository.findById(advisorId).get();
        studentRequest.setAdvisor(advisor);
        studentRepository.save(studentRequest);
        return new ResponseEntity<>(studentRequest, HttpStatus.CREATED);
    }

    @Override
    public List<StudentEntity> findByAdvisorId(Long advisorId) {
        List<StudentEntity> studentEntities = studentRepository.findStudentEntityByAdvisor_AdvisorId(advisorId);
        return studentEntities;
    }

    @Override
    public List<StudentEntity> fetchStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentEntities;
    }

    @Override
    public StudentEntity findStudentEntityById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public StudentEntity updateStudentById(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    public List<StudentEntity> findHighHonorStudents() {
        return studentRepository.findHighHonorStudents();
    }

    @Override
    public List<StudentEntity> findStudentsByYear(Long enrollmentYear) {
        return studentRepository.findByStudentsByEnrollmentYearGiven(enrollmentYear);
    }

    @Override
    public List<StudentEntity> findStudentsByCGPA(Double cgpa) {
        return studentRepository.findByCgpaGreaterThanEqual(cgpa);
    }

}
