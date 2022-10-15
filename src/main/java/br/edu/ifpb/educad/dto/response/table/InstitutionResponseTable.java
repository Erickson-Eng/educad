package br.edu.ifpb.educad.dto.response.table;

import br.edu.ifpb.educad.dto.response.InstitutionResponse;
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
public class InstitutionResponseTable {
    @JsonProperty("institutionList")
    private List<InstitutionResponse> institutionResponseList;
}
