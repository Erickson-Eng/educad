package br.edu.ifpb.educad.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

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
    private UUID id;
    private String name;
    private String period;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Teacher teacher;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

}