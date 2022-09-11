package br.edu.ifpb.educad.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {

    private Long id;
    private String street;
    private String complement;
    private String number;
    private String city;
    private String state;
    private String zipCode;

    private LocalDate createdDate;
    private LocalDate modifiedDate;
}
