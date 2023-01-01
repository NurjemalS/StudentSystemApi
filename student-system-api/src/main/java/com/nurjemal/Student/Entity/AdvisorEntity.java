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
@Table(
        uniqueConstraints = { @UniqueConstraint(name = "advisor_mail_unique", columnNames = "email") }
)
public class AdvisorEntity {

    @Id
    @SequenceGenerator(name = "advisor_sequence", sequenceName = "advisor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "advisor_sequence")
    @Column(updatable = false)
    private Long advisorId;
    @Column(nullable = false)
    private String advisorName;
    @Column(nullable = false)
    private String email;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OnDelete(action = OnDeleteAction.NO_ACTION) // if advisor is deleted, department will stay
    @JoinColumn(name="department_id", referencedColumnName = "departmentId")
    @JsonIgnore
    private DepartmentEntity department;



    @OneToMany(mappedBy="advisor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentEntity> students;

}
