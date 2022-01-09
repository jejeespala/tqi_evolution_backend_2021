package com.loan.company.entities;

import java.time.LocalDate;
import javax.validation.constraints.Max;

public class Loan {

    private Long id;
    private Double value;
    private LocalDate dateInstallments;

    @Max(value = 60, message = "O máximo de parcelas é de 60")
    private Integer installments;




}
