package com.loan.company.Mapper;

import com.loan.company.dto.AddressDTO;
import com.loan.company.dto.LoanDTO;
import com.loan.company.entities.Address;
import com.loan.company.entities.Client;
import com.loan.company.dto.ClientDTO;
import com.loan.company.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {


    Client toModel(ClientDTO clientDTO);

    ClientDTO toDTO(Client client);

    Address toModel(AddressDTO addressDTO);

    AddressDTO addressToAddressDto(Address address);




}
