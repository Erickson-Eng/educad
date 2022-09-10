package br.edu.ifpb.educad.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Profile implements Serializable {
    private static final long serialVersionUID = -4995864704146338137L;
    private UUID id;
    private String fullName;
    private LocalDate birthDate;
    private String cpf;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    private Address address;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

}