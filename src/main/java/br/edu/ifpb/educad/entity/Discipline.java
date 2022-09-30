package br.edu.ifpb.educad.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
@Table(name = "discipline")
public class Discipline implements Serializable {
    private static final long serialVersionUID = -3776342300975109583L;

    public Discipline(String name, String period, String registration, Teacher teacher) {
        this.name = name;
        this.period = period;
        this.registration = registration;
        this.teacher = teacher;
        this.createdDate = LocalDate.now();
        this.modifiedDate = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discipline_seq")
    @SequenceGenerator(name = "discipline_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String period;

    private String registration;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Teacher teacher;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;

}