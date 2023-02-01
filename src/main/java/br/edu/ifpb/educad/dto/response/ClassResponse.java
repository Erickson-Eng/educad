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
public class ClassResponse {

    private String name;
    private String period;
    private Long subjectId;
    private Long teacherId;
    private LocalDate createdDate;
    private LocalDate modifiedDate;

}
