package br.edu.ifpb.educad.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionRequest {
    @NotBlank
    private String name;
    @NotNull
    private AddressRequest addressRequest;
}