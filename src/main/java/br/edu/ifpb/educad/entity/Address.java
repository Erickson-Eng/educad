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
@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 247703941687283315L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String street;
    private String complement;
    private String number;
    private String city;
    private String state;
    private String zipCode;

}