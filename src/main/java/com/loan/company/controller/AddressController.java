package com.loan.company.controller;

import com.loan.company.dto.*;
import com.loan.company.entities.Client;
import com.loan.company.exception.AddressNotFoundException;
import com.loan.company.exception.ClientNotFoundException;
import com.loan.company.exception.LoanNotFoundException;
import com.loan.company.service.AddressService;
import com.loan.company.service.ClientService;
import com.loan.company.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {

    private final AddressService addressService;
    private final ClientService clientService;


    @PostMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@PathVariable("id") Long clientId, @RequestBody @Valid AddressDTO addressDTO) throws ClientNotFoundException {


        System.out.println("entrou");
        ClientDTO clientDTO = clientService.findById(clientId);


        return addressService.create(addressDTO, clientDTO);
    }

    @GetMapping
    public List<ListAddressDTO> addresses(){

        System.out.println("ENTROU");
        return addressService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO findById(@PathVariable Long id) throws AddressNotFoundException{

        return addressService.findById(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) throws AddressNotFoundException{
        return addressService.update(id, addressDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws AddressNotFoundException {
        addressService.delete(id);
    }


//    @PostMapping(value = "/{id}")
//    public MessageResponseDTO requestLoan(@PathVariable Long clientId, @PathVariable Long loanId) throws AddressNotFoundException {
//
//        AddressDTO addressDTO = addressService.findById(clientId);
//        LoanDTO loanDTO = loanService.findById(loanId);
//
//        return addressService.createLoan(addressDTO, loanDTO);
//
//    }

}
