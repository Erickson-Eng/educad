package br.edu.ifpb.educad.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest{

    @NotBlank
    private String fullName;

    private LocalDate birthDate;

    @NotBlank
    // @CPF(message = "CPF inválido") Validação falhando para mesmo para o padrão 123.123.123-15
    private String cpf;

    @NotNull
    private Long userId;

    @NotNull
    private AddressRequest address;

    private String value;

}
