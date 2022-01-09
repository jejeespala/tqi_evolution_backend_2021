package com.loan.company.Mapper;

import com.loan.company.dto.LoanDTO;
import com.loan.company.entities.Loan;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanMapper extends JpaRepository<Loan, Long> {

    @Mapping(target = "dateInstallments", source = "dateInstallments", dateFormat = "yyyy-MM-dd")
    Loan toModel(LoanDTO loanDTO);

    LoanDTO toDTO(Loan loan);

}
