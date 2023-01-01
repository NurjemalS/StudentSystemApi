package com.nurjemal.Student.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentEntity {

    @Id
    @SequenceGenerator(name = "department_sequence", sequenceName = "department_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_sequence")
    @Column(updatable = false)
    private Long departmentId;
    private String abbr;
    @Column(nullable = false)
    private String departmentName;
    private String location;
    private Integer studentNumber;


    @JsonIgnore
    @OneToMany(mappedBy="department", cascade = CascadeType.ALL)
    private List<AdvisorEntity> advisorEntities;

    //@JsonIgnore
    @OneToMany( mappedBy="department",  cascade = CascadeType.ALL)
    private List<StudentEntity> studentEntities;



}
