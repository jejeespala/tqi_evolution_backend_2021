package com.loan.company.controller;

import com.loan.company.dto.ClientDTO;
import com.loan.company.dto.MessageResponseDTO;
import com.loan.company.entities.Client;
import com.loan.company.exception.ClientNotFoundException;
import com.loan.company.exception.LoanNotFoundException;
import com.loan.company.repositories.ClientRepository;
import com.loan.company.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {


    private final ClientService clientService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid ClientDTO clientDTO){

        return clientService.create(clientDTO);
    }

    @GetMapping
    public List<ClientDTO> clients(){

        System.out.println("ENTROU");
        return clientService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO findById(@PathVariable Long id) throws ClientNotFoundException{

        return clientService.findById(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) throws ClientNotFoundException{
        return clientService.update(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ClientNotFoundException {
        clientService.delete(id);
    }


    @PostMapping(value = "/{clientId}/loan/{loanId}/add")
    public MessageResponseDTO requestLoan(@PathVariable Long clientId, @PathVariable Long loanId) throws ClientNotFoundException, LoanNotFoundException {

        return clientService.createLoan(clientId, loanId);

    }

}
