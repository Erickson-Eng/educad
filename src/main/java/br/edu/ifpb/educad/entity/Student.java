package br.edu.ifpb.educad.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class Student extends Profile {

    private static final long serialVersionUID = -5253161063449024945L;

    public Student(String fullName, LocalDate birthDate, String cpf, User user, Address address, String matriculation, String course, String period, LocalDate entryDate) {
        super(fullName, birthDate, cpf, user, address);
        this.matriculation = matriculation;
        this.course = course;
        this.period = period;
        this.entryDate = entryDate;
    }

    private String matriculation;

    private String course;

    private String period;

    @ManyToMany
    @JoinTable(
            name = "student_class",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<Class> classes;

    private LocalDate entryDate;

}