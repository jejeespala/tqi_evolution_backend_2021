package com.loan.company.controller;

import com.loan.company.dto.ClientDTO;
import com.loan.company.dto.LoanDTO;
import com.loan.company.dto.MessageResponseDTO;
import com.loan.company.exception.ClientNotFoundException;
import com.loan.company.exception.LoanNotFoundException;
import com.loan.company.service.ClientService;
import com.loan.company.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/loans")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoanController {


    private final LoanService loanService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid LoanDTO loanDTO){

        return loanService.create(loanDTO);
    }

    @GetMapping
    public List<LoanDTO> loans(){

        System.out.println("ENTROU");
        return loanService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LoanDTO findById(@PathVariable Long id) throws LoanNotFoundException{

        return loanService.findById(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid LoanDTO loanDTO) throws LoanNotFoundException{
        return loanService.update(id, loanDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws LoanNotFoundException {
        loanService.delete(id);
    }


}
