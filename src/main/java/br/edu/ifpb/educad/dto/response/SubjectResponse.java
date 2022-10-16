package br.edu.ifpb.educad.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse {

    private String name;
    private String period;
    private String registration;
    private Long teacherId;

}
