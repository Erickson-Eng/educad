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
public class TeacherResponse {
    private String fullName;
    private LocalDate birthDate;
    private String cpf;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private Long userId;
    private AddressResponse addressResponse;
}
