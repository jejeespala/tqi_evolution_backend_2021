package com.loan.company.dto;

import com.loan.company.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {

    private Long id;

    @NotNull
    private Long value;

    @NotNull
    private String dateInstallments;

    @NotNull
    private Integer installments;

    @Valid
    @NotNull
    private Client client;

}
