package br.edu.ifpb.educad.service;

import br.edu.ifpb.educad.dto.request.AddressRequest;
import br.edu.ifpb.educad.dto.response.AddressResponse;

public interface AddressService {

    AddressResponse save (AddressRequest addressRequest);

    AddressResponse update(Long id, AddressRequest addressRequest);

    AddressResponse delete(Long id);

    AddressResponse findAddressById(Long id);
}
