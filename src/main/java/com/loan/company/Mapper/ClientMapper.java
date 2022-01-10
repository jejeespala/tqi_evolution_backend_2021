package com.loan.company.Mapper;

import com.loan.company.dto.AddressDTO;
import com.loan.company.dto.ListClientDTO;
import com.loan.company.dto.LoanDTO;
import com.loan.company.entities.Address;
import com.loan.company.entities.Client;
import com.loan.company.dto.ClientDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientMapper {


    Client toModel(ClientDTO clientDTO);

    ClientDTO toDTO(Client client);

    ListClientDTO toListClientDTO(Client client);




}
