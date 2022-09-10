package br.edu.ifpb.educad.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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


}