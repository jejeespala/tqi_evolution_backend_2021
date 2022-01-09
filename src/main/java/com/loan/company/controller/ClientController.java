package com.loan.company.controller;

import com.loan.company.dto.ClientDTO;
import com.loan.company.dto.MessageResponseDTO;
import com.loan.company.entities.Client;
import com.loan.company.repositories.ClientRepository;
import com.loan.company.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

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

//    public Client client(@RequestBody Client client){
//
//        return repository.save(client);
//    }


}
