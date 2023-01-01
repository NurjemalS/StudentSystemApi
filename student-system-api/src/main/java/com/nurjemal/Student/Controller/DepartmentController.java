package com.nurjemal.Student.Controller;

import com.nurjemal.Student.Entity.DepartmentEntity;
import com.nurjemal.Student.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    // insert a department
    @PostMapping("/departments")
    public ResponseEntity<DepartmentEntity> saveDepartment(@RequestBody DepartmentEntity department){
        return departmentService.createDepartment(department);
    }

    // get all departments
    @GetMapping("/departments")
    public List<DepartmentEntity> fetchDepartments(){
        return departmentService.fetchDepartments();
    }



    //get a department by id
    @GetMapping("/departments/{department_id}")
    public ResponseEntity<DepartmentEntity> findDepartmentEntityById(@PathVariable("department_id") Long departmentId){
        DepartmentEntity departmentEntity = departmentService.findDepartmentEntityById(departmentId);
        return new ResponseEntity<>(departmentEntity, HttpStatus.OK);
    }

    // update department by id
    @PutMapping("/departments/{department_id}")
    public DepartmentEntity updateDepartmentEntityById(@PathVariable("department_id") Long departmentId, @RequestBody DepartmentEntity departmentRequest){
        DepartmentEntity departmentEntity = departmentService.findDepartmentEntityById(departmentId);
        departmentEntity.setDepartmentName(departmentRequest.getDepartmentName());
        departmentEntity.setAbbr(departmentRequest.getAbbr());
        departmentEntity.setLocation(departmentEntity.getLocation());
        departmentEntity.setStudentNumber(departmentRequest.getStudentNumber());
        return departmentService.update(departmentEntity);
    }

    /*
    // delete department by id
    @DeleteMapping("/departments/{department_id}")
    public ResponseEntity<HttpStatus> deleteDepartmentEntityById(@PathVariable("department_id") Long departmentId) {
        departmentService.deleteDepartmentEntityById(departmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
