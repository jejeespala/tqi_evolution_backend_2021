package com.loan.company.service;

import com.loan.company.Mapper.ClientMapper;
import com.loan.company.dto.ClientDTO;
import com.loan.company.dto.LoanDTO;
import com.loan.company.dto.MessageResponseDTO;
import com.loan.company.entities.Client;
import com.loan.company.exception.ClientNotFoundException;
import com.loan.company.exception.LoanNotFoundException;
import com.loan.company.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private ClientRepository clientRepository;

    private final LoanService loanService;

    private final ClientMapper clientMapper;


    public MessageResponseDTO create(ClientDTO clientDTO){


        Client client = clientMapper.toModel(clientDTO);

        Client savedClient = clientRepository.save(client);

        MessageResponseDTO messageResponse = createMessageResponse("Client successfuly created with ID ", savedClient.getId());

        return messageResponse;


    }

    public MessageResponseDTO createLoan(Long clientId, Long loanId) throws ClientNotFoundException, LoanNotFoundException {

        ClientDTO clientDTO = findById(clientId);
        LoanDTO loanDTO = loanService.findById(loanId);




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

    public ClientDTO findById(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        return clientMapper.toDTO(client);
    }

    public MessageResponseDTO update(Long id, ClientDTO clientDTO) throws ClientNotFoundException {
        clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        Client updateClient = clientMapper.toModel(clientDTO);
        Client client = clientRepository.save(updateClient);

        MessageResponseDTO messageResponse = createMessageResponse("Client successfully updated with ID ", client.getId());

        return messageResponse;
    }

    public void delete(Long id) throws ClientNotFoundException {
        clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        clientRepository.deleteById(id);
    }



    private MessageResponseDTO createMessageResponse(String s, Long id){
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }
}
