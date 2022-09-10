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
    private String matriculation;
    private String course;
    private String period;
    private LocalDate entryDate;

}