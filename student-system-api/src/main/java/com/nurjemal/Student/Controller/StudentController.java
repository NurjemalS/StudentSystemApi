package com.nurjemal.Student.Controller;

import com.nurjemal.Student.Entity.StudentEntity;
import com.nurjemal.Student.Service.AdvisorService;
import com.nurjemal.Student.Service.DepartmentService;
import com.nurjemal.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private AdvisorService advisorService;

    /*
    // Insert a student for specific department
    @PostMapping("/departments/{departmentId}/students")
    public ResponseEntity<StudentEntity> createStudentForSpecificDepartment(@PathVariable(value = "departmentId") Long departmentId, @RequestBody StudentEntity studentRequest) {

        return studentService.createStudentForSpecificDepartment(departmentId, studentRequest);
    }

    // Insert a student for specific advisor
    @PostMapping("/advisors/{advisorId}/students")
    public ResponseEntity<StudentEntity> createStudentForSpecificAdvisor(@PathVariable(value = "advisorId") Long advisorId, @RequestBody StudentEntity studentRequest) {

        return studentService.createStudentForSpecificAdvisor(advisorId, studentRequest);
    }*/

    // Insert a student for specific department and advisor
    @PostMapping("/departments/{departmentId}/advisors/{advisorId}/students")
    public ResponseEntity<StudentEntity> createStudentForSpecificDepartmentAndAdvisor(@PathVariable(value = "departmentId") Long departmentId, @PathVariable(value = "advisorId") Long advisorId, @RequestBody StudentEntity studentRequest) {

        return studentService.createStudentForSpecificDepartmentAndAdvisor(departmentId, advisorId, studentRequest);
    }


    // get all students for a specific department
    @GetMapping("/departments/{departmentId}/students")
    public ResponseEntity<List<StudentEntity>> findStudentEntityByDepartment_DepartmentId(@PathVariable(value = "departmentId") Long departmentId) {
        if (!departmentService.existsById(departmentId)) {
            System.out.println("Not found Department with id = " + departmentId);
        }
        List<StudentEntity> studentEntities = studentService.findByDepartmentId(departmentId);
        return new ResponseEntity<>(studentEntities, HttpStatus.OK);
    }

    // get all students for a specific advisor
    @GetMapping("/advisors/{advisorId}/students")
    public ResponseEntity<List<StudentEntity>> findStudentEntityByAdvisor_AdvisorId(@PathVariable(value = "advisorId") Long advisorId) {
        if (!advisorService.existsById(advisorId)) {
            System.out.println("Not found Advisor with id = " + advisorId);
        }
        List<StudentEntity> studentEntities = studentService.findByAdvisorId(advisorId);
        return new ResponseEntity<>(studentEntities, HttpStatus.OK);
    }


    // get all students
    @GetMapping("/students")
    public List<StudentEntity> fetchStudents(){
        return studentService.fetchStudents();
    }


    //get a student by id
    @GetMapping("/students/{student_id}")
    public ResponseEntity<StudentEntity> findStudentEntityById(@PathVariable(value = "student_id") Long studentId){
        StudentEntity studentEntity = studentService.findStudentEntityById(studentId);
        return new ResponseEntity<>(studentEntity, HttpStatus.OK);
    }

    // update student by id
    @PutMapping("/students/{student_id}")
    public StudentEntity updateStudentEntityById(@PathVariable(value = "student_id") Long studentId, @RequestBody StudentEntity studentRequest){
        StudentEntity studentEntity = studentService.findStudentEntityById(studentId);
        studentEntity.setStudentName(studentRequest.getStudentName());
        studentEntity.setDepartment(studentRequest.getDepartment());
        studentEntity.setEmail(studentRequest.getEmail());
        studentEntity.setEnrollmentYear(studentRequest.getEnrollmentYear());
        studentEntity.setCgpa(studentRequest.getCgpa());
        return studentService.updateStudentById(studentEntity);
    }

    //get  students who have gcpa >= 3.50 ---> can be changed from repository method query
    @GetMapping("/students/high-honor-students")
    public List<StudentEntity> findHighHonorStudents(){
        return studentService.findHighHonorStudents();
    }


    //get  students who enrolled in year x
    @GetMapping("/students/year/{enrollment_year}")
    public List<StudentEntity> findStudentsByYear(@PathVariable(value = "enrollment_year") Long enrollment_year){
        return studentService.findStudentsByYear(enrollment_year);
    }

    //get  students who  have gcpa >= x
    @GetMapping("/students/cgpa/{cgpa}")
    public List<StudentEntity> findStudentsByCGPA(@PathVariable(value =  "cgpa") Double cgpa){
        return studentService.findStudentsByCGPA(cgpa);
    }




}
