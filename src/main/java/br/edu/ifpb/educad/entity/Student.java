package br.edu.ifpb.educad.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

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
    private LocalDate entryDate;

}