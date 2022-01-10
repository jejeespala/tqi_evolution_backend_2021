package com.loan.company.service;

import com.loan.company.Mapper.AddressMapper;
import com.loan.company.Mapper.ClientMapper;
import com.loan.company.Mapper.LoanMapper;
import com.loan.company.dto.*;
import com.loan.company.dto.AddressDTO;
import com.loan.company.entities.Address;
import com.loan.company.entities.Client;
import com.loan.company.entities.Loan;
import com.loan.company.exception.AddressNotFoundException;
import com.loan.company.exception.LoanNotFoundException;
import com.loan.company.repositories.AddressRepository;
import com.loan.company.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {

    private AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    private final ClientMapper clientMapper;


    public MessageResponseDTO create(AddressDTO addressDTO, ClientDTO clientDTO){

        System.out.println("Chegou: "+addressDTO);
        System.out.println("Chegou: " +clientDTO);

        Address address = addressMapper.toModel(addressDTO);
        Client client = clientMapper.toModel(clientDTO);


        address.setClient(client);
        Address savedAddress = addressRepository.save(address);


        MessageResponseDTO messageResponse = createMessageResponse("Adrress successfuly created with ID ", savedAddress.getId());

        return messageResponse;


    }

    public List<ListAddressDTO> listAll(){

        System.out.println("vai comerçar");
        List<Address> addresses = addressRepository.findAll();

        System.out.println("MEUS CLIENTES " + addresses);


        return addresses.stream()
                .map(addressMapper::toListAddressDTO)
                .collect(Collectors.toList());
    }

    public AddressDTO findById(Long id) throws AddressNotFoundException {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));

        return addressMapper.toDTO(address);
    }

    public MessageResponseDTO update(Long id, AddressDTO AddressDTO) throws AddressNotFoundException {
        addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));

        Address updateAddress = addressMapper.toModel(AddressDTO);
        Address address = addressRepository.save(updateAddress);

        MessageResponseDTO messageResponse = createMessageResponse("Address successfully updated with ID ", address.getId());

        return messageResponse;
    }

    public void delete(Long id) throws AddressNotFoundException {
        addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));

        addressRepository.deleteById(id);
    }



    private MessageResponseDTO createMessageResponse(String s, Long id){
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }
}
