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
@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 247703941687283315L;
    private UUID id;
    private String street;
    private String complement;
    private String number;
    private String city;
    private String state;
    private String zipCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

}