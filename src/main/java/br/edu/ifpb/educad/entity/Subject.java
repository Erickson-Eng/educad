package br.edu.ifpb.educad.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "subject")
public class Subject implements Serializable {
    private static final long serialVersionUID = -3776342300975109583L;

    public Subject(String name, String period, String registration, Teacher teacher) {
        this.name = name;
        this.period = period;
        this.registration = registration;
        this.teacher = teacher;
        this.createdDate = LocalDate.now();
        this.modifiedDate = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq")
    @SequenceGenerator(name = "subject_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String period;

    private String registration;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Teacher teacher;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;

}