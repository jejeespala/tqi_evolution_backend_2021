package com.loan.company.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.Max;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long value;


    private LocalDate dateInstallments;

    @Max(value = 60, message = "O máximo de parcelas é de 60")
    private Integer installments;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;




}
