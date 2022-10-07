package br.edu.ifpb.educad.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    @NotBlank
    private String name;
    // private Integer numberOfPeriods;

}
