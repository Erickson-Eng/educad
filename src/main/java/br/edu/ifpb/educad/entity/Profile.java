package br.edu.ifpb.educad.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Profile implements Serializable {
    private static final long serialVersionUID = -4995864704146338137L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    @SequenceGenerator(name = "profile_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String fullName;
    private LocalDate birthDate;
    private String cpf;

    @OneToOne(cascade = {CascadeType.REFRESH})
    private User user;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    private Address address;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;

}