package br.edu.ifpb.educad.dto.mapper;

import br.edu.ifpb.educad.dto.request.InstitutionRequest;
import br.edu.ifpb.educad.dto.response.InstitutionResponse;
import br.edu.ifpb.educad.entity.Institution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface InstitutionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    @Mapping(source = "addressRequest", target = "address")
    Institution institutionRequestToEntity(InstitutionRequest institutionRequest);

    @Mapping(source = "address", target = "addressResponse")
    InstitutionResponse entityToInstitutionResponse(Institution institution);
}
