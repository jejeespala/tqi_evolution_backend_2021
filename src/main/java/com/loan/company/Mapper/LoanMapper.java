package com.loan.company.Mapper;

import com.loan.company.dto.LoanDTO;
import com.loan.company.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface LoanMapper {

    //@Mapping(target = "dateInstallments", source = "dateInstallments", dateFormat = "yyyy-MM-dd")
    Loan toModel(LoanDTO loanDTO);

    LoanDTO toDTO(Loan loan);

}
