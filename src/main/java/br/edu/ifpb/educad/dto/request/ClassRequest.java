package br.edu.ifpb.educad.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String period;

    @NotNull
    private String subject;

    @NotNull
    private Long teacherId;

}
