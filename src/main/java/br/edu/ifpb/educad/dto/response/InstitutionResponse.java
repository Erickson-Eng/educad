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
public class InstitutionResponse {
    private Long id;
    private String name;
    private AddressResponse addressResponse;

    private LocalDate createdDate;
    private LocalDate modifiedDate;
}
