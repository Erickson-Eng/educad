package br.edu.ifpb.educad.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {

    @NotBlank
    @Min(5)
    @Max(30)
    private String username;
    @NotBlank
    @Min(8)
    @Max(12)
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String cellphone;
}
