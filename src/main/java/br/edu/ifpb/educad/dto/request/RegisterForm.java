package br.edu.ifpb.educad.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {

    @NotBlank
    @Size(min = 5, max = 30)
    private String username;
    @NotBlank
    @Size(min = 8, max = 12)
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String cellphone;
}
