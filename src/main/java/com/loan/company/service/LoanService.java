package com.loan.company.service;

import com.loan.company.Mapper.ClientMapper;
import com.loan.company.Mapper.LoanMapper;
import com.loan.company.dto.ClientDTO;
import com.loan.company.dto.LoanDTO;
import com.loan.company.dto.MessageResponseDTO;
import com.loan.company.entities.Client;
import com.loan.company.entities.Loan;
import com.loan.company.exception.ClientNotFoundException;
import com.loan.company.exception.LoanNotFoundException;
import com.loan.company.repositories.ClientRepository;
import com.loan.company.repositories.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoanService {


    private LoanRepository loanRepository;

    private final LoanMapper loanMapper;

    public MessageResponseDTO create(LoanDTO loanDTO){


        Loan loan = loanMapper.toModel(loanDTO);

        Loan savedLoan = loanRepository.save(loan);

        MessageResponseDTO messageResponse = createMessageResponse("Loan successfuly created with ID ", savedLoan.getId());

        return messageResponse;


    }

    public List<LoanDTO> listAll(){

        List<Loan> loans = loanRepository.findAll();


        return loans.stream()
                .map(loanMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LoanDTO findById(Long id) throws LoanNotFoundException {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));

        return loanMapper.toDTO(loan);
    }

    public MessageResponseDTO update(Long id, LoanDTO loanDTO) throws LoanNotFoundException {
        loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));

        Loan updateLoan = loanMapper.toModel(loanDTO);
        Loan loan = loanRepository.save(updateLoan);

        MessageResponseDTO messageResponse = createMessageResponse("Loan successfully updated with ID ", loan.getId());

        return messageResponse;
    }

    public void delete(Long id) throws LoanNotFoundException {
        loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException(id));

        loanRepository.deleteById(id);
    }


    private MessageResponseDTO createMessageResponse(String s, Long id){
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }
}
