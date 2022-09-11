package br.edu.ifpb.educad.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private String street;
    private String complement;
    private String number;
    private String city;
    private String state;
    private String zipCode;

}
