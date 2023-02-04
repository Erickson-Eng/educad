package br.edu.ifpb.educad.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "class")
public class Class implements Serializable {

    private static final long serialVersionUID = -8392072614106928893L;

    public Class(String subject,
                 String period,
                 Teacher teacher,
                 Set<Student> students,
                 LocalDate createdDate,
                 LocalDate modifiedDate) {
        this.period = period;
        this.teacher = teacher;
        this.subject = subject;
        this.students = students;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_gen")
    @SequenceGenerator(name = "class_gen")
    @Column(name = "id", nullable = false)
    private Long id;

    private String subject;

    private String period;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Teacher teacher;

    @ManyToMany(mappedBy = "classes")
    private Set<Student> students;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;

    public Long getId() {
        return id;
    }

}
