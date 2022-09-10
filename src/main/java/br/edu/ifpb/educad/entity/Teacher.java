package br.edu.ifpb.educad.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "teacher")
public class Teacher extends Profile {
    private static final long serialVersionUID = 5112183181912923264L;
    private String value;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teach_discipline_mapping",
            joinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "discipline_id", referencedColumnName = "id")})
    @MapKey(name = "registration")
    @ToString.Exclude
    private Map<String, Discipline> disciplineMap;

}