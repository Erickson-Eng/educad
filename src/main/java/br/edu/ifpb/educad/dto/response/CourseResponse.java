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
public class CourseResponse {

    private String name;
    private String institutionName;
    private LocalDate createdDate;
    private LocalDate modifiedDate;

}
