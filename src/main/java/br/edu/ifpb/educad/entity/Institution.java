package br.edu.ifpb.educad.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "institution")
public class Institution implements Serializable {
    private static final long serialVersionUID = -207392191958171304L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "institution_seq")
    @SequenceGenerator(name = "institution_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    private Address address;

    @OneToMany(mappedBy = "institution")
    private Set<Course> courses;

    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDate modifiedDate;

}