package com.nurjemal.Student.Service;

import com.nurjemal.Student.Entity.AdvisorEntity;
import com.nurjemal.Student.Entity.DepartmentEntity;
import com.nurjemal.Student.Repository.AdvisorRepository;
import com.nurjemal.Student.Repository.DepartmentRepository;
import com.nurjemal.Student.Repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdvisorServiceImpl implements AdvisorService{

    private AdvisorRepository advisorRepository;
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;


    public AdvisorServiceImpl(AdvisorRepository advisorRepository, DepartmentRepository departmentRepository, StudentRepository studentRepository) {
        this.advisorRepository = advisorRepository;
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }


   /* public Advisor createAdvisor(Advisor advisor) {
        AdvisorEntity advisorEntity = new AdvisorEntity();
        BeanUtils.copyProperties(advisor, advisorEntity);
        advisorRepository.save(advisorEntity);
        return advisor;
    }*/

    @Override
    public ResponseEntity<AdvisorEntity> createAdvisorForSpecificDepartment(Long departmentId, AdvisorEntity advisorRequest) {
        DepartmentEntity department = departmentRepository.findById(departmentId).get();
        advisorRequest.setDepartment(department);
        advisorRepository.save(advisorRequest);
        return new ResponseEntity<>(advisorRequest, HttpStatus.CREATED);
    }

    @Override
    public List<AdvisorEntity> findByDepartmentId(Long departmentId) {
        List<AdvisorEntity> advisorEntityList = advisorRepository.findAdvisorEntityByDepartment_DepartmentId(departmentId);
        return advisorEntityList;
    }

    @Override
    public AdvisorEntity findAdvisorEntityById(Long advisorId) {
        return advisorRepository.findById(advisorId).get();
    }

    @Override
    public AdvisorEntity save(AdvisorEntity advisorEntity) {
        return advisorRepository.save(advisorEntity);

    }

    @Override
    public void deleteAdvisorById(Long advisorId) {
        advisorRepository.deleteById(advisorId);
    }

    @Override
    public List<AdvisorEntity> fetchAdvisors() {
        List<AdvisorEntity> advisorEntities = advisorRepository.findAll();
        return advisorEntities;
    }

    @Override
    public boolean existsById(Long advisorId) {
        return advisorRepository.existsById(advisorId);
    }


}
