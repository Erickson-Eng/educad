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
@Table(name = "course")
public class Course implements Serializable {
    private static final long serialVersionUID = -1358145327397413208L;
    private Long id;
    private String name;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Institution institution;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq")
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

}