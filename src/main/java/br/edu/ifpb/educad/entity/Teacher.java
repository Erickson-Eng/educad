package br.edu.ifpb.educad.entity;

import lombok.*;

import javax.persistence.*;

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

}