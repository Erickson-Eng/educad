package br.edu.ifpb.educad.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotBlank
    private String fullName;
    private LocalDate birthDate;
    @NotBlank
    @CPF
    private String cpf;
    @NotNull
    private Long userId;
    @NotNull
    private AddressRequest addressRequest;
    @NotBlank
    private String matriculation;
    @NotBlank
    private String course;
    @NotBlank
    private String period;
    @NotNull
    private LocalDate entryDate;

}
