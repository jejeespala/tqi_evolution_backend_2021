package com.loan.company.service;

import com.loan.company.Mapper.ClientMapper;
import com.loan.company.dto.ClientDTO;
import com.loan.company.dto.MessageResponseDTO;
import com.loan.company.entities.Client;
import com.loan.company.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private final ClientMapper clientMapper;


    public MessageResponseDTO create(ClientDTO clientDTO){

        Client client = clientMapper.toModel(clientDTO);

        Client savedClient = clientRepository.save(client);

        MessageResponseDTO messageResponse = createMessageResponse("Client successfuly created with ID ", savedClient.getId());

        return messageResponse;


    }

    public List<ClientDTO> listAll(){

        System.out.println("vai comerçar");
        List<Client> clients = clientRepository.findAll();

        System.out.println("MEUS CLIENTES " + clients);

        System.out.println(clients.stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList()));

        return clients.stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    private MessageResponseDTO createMessageResponse(String s, Long id){
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }
}
