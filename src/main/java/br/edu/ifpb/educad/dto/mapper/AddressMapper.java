package br.edu.ifpb.educad.dto.mapper;

import br.edu.ifpb.educad.dto.request.AddressRequest;
import br.edu.ifpb.educad.dto.response.AddressResponse;
import br.edu.ifpb.educad.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    Address addressRequestToEntity(AddressRequest addressRequest);

    AddressResponse entityToAddressResponse(Address address);
}
