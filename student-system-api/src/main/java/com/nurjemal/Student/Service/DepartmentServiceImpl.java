package com.nurjemal.Student.Service;


import com.nurjemal.Student.Entity.AdvisorEntity;
import com.nurjemal.Student.Entity.DepartmentEntity;
import com.nurjemal.Student.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{


    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ResponseEntity<DepartmentEntity> createDepartment(DepartmentEntity departmentRequest) {
        departmentRepository.save(departmentRequest);
        return new ResponseEntity<>(departmentRequest, HttpStatus.CREATED);
    }

    @Override
    public List<DepartmentEntity> fetchDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities;
    }


    @Override
    public DepartmentEntity findDepartmentEntityById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public DepartmentEntity update(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public void deleteDepartmentEntityById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public boolean existsById(Long departmentId) {
        return departmentRepository.existsById(departmentId);
    }
}
