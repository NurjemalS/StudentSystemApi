package com.nurjemal.Student.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (
        uniqueConstraints = { @UniqueConstraint(name = "student_mail_unique", columnNames = "email") }
)
public class StudentEntity {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(updatable = false)
    private Long studentId;
    @Column(nullable = false)
    private String studentName;
    private Long enrollmentYear;
    private double cgpa;
    @Column(nullable = false)
    private String email;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    @JoinColumn(name="advisor_id", referencedColumnName = "advisorId")
    private AdvisorEntity advisor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    @JoinColumn(name="department_id", referencedColumnName = "departmentId")
    private DepartmentEntity department;




}
