package com.nurjemal.Student.Service;

import com.nurjemal.Student.Entity.AdvisorEntity;
import com.nurjemal.Student.Entity.DepartmentEntity;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface DepartmentService {
    ResponseEntity<DepartmentEntity> createDepartment(DepartmentEntity department);

    //List<Department> fetchDepartments();

    boolean existsById(Long departmentId);

    List<DepartmentEntity> fetchDepartments();

    DepartmentEntity findDepartmentEntityById(Long departmentId);

    DepartmentEntity update(DepartmentEntity departmentEntity);


    void deleteDepartmentEntityById(Long departmentId);
}
