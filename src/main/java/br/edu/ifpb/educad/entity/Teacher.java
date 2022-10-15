package br.edu.ifpb.educad.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;

// A anotação @Builder causa erro com o MapStruct
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "teacher")
public class Teacher extends Profile {
    private static final long serialVersionUID = 5112183181912923264L;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @MapKey(name = "registration")
    @ToString.Exclude
    private Map<String, Discipline> disciplineMap;

    public Teacher(String fullName, LocalDate birthDate, String cpf, User user, Address address, Map<String, Discipline> disciplineMap) {
        super(fullName, birthDate, cpf, user, address);
        this.disciplineMap = disciplineMap;
    }
}