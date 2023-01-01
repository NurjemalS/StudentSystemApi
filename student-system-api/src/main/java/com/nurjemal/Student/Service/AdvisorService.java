package com.nurjemal.Student.Service;

import com.nurjemal.Student.Entity.AdvisorEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdvisorService {


    ResponseEntity<AdvisorEntity> createAdvisorForSpecificDepartment(Long departmentId, AdvisorEntity advisorRequest);

    List<AdvisorEntity> findByDepartmentId(Long departmentId);

    AdvisorEntity findAdvisorEntityById(Long advisorId);

   AdvisorEntity save(AdvisorEntity advisorEntity);

    void deleteAdvisorById(Long advisorId);

    List<AdvisorEntity> fetchAdvisors();

    boolean existsById(Long advisorId);
}
