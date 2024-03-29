package br.edu.ifpb.educad.dto.response.table;

import br.edu.ifpb.educad.dto.response.StudentResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseTable {

    @JsonProperty("studentList")
    private List<StudentResponse> studentResponseList;
}
