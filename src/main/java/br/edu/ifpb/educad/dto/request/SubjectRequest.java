package br.edu.ifpb.educad.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String period;

    @NotBlank
    private String registration;

}