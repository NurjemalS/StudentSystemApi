package com.nurjemal.Student.Repository;

import com.nurjemal.Student.Entity.DepartmentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    @Transactional
    void deleteDepartmentEntityByDepartmentId(Long departmentId);

    Optional<DepartmentEntity> findById(Long departmentId);

}
