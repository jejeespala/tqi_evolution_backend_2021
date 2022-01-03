package com.loan.company.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientResource {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public List<Client> clients(){

        return repository.findAll();
    }

    public Client client(@RequestBody Client client){

        return repository.save(client);
    }
}
