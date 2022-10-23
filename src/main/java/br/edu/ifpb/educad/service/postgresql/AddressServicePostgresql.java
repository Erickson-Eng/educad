package br.edu.ifpb.educad.service.postgresql;

import br.edu.ifpb.educad.dto.mapper.AddressMapper;
import br.edu.ifpb.educad.dto.request.AddressRequest;
import br.edu.ifpb.educad.dto.response.AddressResponse;
import br.edu.ifpb.educad.entity.Address;
import br.edu.ifpb.educad.repository.AddressRepository;
import br.edu.ifpb.educad.service.AddressService;
import br.edu.ifpb.educad.service.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressServicePostgresql implements AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;
    @Transactional
    @Override
    public AddressResponse save(AddressRequest addressRequest) {
        try{
            Address address = addressMapper.addressRequestToEntity(addressRequest);
            addressRepository.save(address);
            return addressMapper.entityToAddressResponse(address);
        } catch (RuntimeException e){
            throw new DataIntegrityViolationException("Unable to save address");
        }
    }

    @Transactional
    @Override
    public AddressResponse update(Long id, AddressRequest addressRequest) {
        Address obj = verifyIfExist(id);
        updateData(obj, addressRequest);
        addressRepository.save(obj);
        return addressMapper.entityToAddressResponse(obj);
    }

    @Override
    public AddressResponse delete(Long id) {
        Address obj = verifyIfExist(id);
        AddressResponse addressResponse = addressMapper.entityToAddressResponse(obj);
        addressRepository.delete(obj);
        return addressResponse;
    }

    @Override
    public AddressResponse findAddressById(Long id) {
        Address obj  = verifyIfExist(id);
        return addressMapper.entityToAddressResponse(obj);

    }


    protected Address verifyIfExist(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("address not registered"));
    }

    protected void updateData(Address address, AddressRequest addressRequest){
        address.setStreet(addressRequest.getStreet());
        address.setComplement(addressRequest.getComplement());
        address.setNumber(addressRequest.getNumber());
        address.setCity(addressRequest.getCity());
        address.setState(addressRequest.getState());
        address.setZipCode(addressRequest.getZipCode());
    }
}
