package com.nurjemal.Student.Repository;

import com.nurjemal.Student.Entity.AdvisorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvisorRepository extends JpaRepository<AdvisorEntity, Long> {

    List<AdvisorEntity> findAdvisorEntityByDepartment_DepartmentId(Long departmentId);

}
