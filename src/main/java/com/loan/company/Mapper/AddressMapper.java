package com.loan.company.Mapper;

import com.loan.company.dto.AddressDTO;
import com.loan.company.dto.ClientDTO;
import com.loan.company.dto.ListAddressDTO;
import com.loan.company.entities.Address;
import com.loan.company.entities.Client;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AddressMapper {


    Address toModel(AddressDTO addressDTO);

    AddressDTO toDTO(Address address);

    ListAddressDTO toListAddressDTO(Address address);


}
