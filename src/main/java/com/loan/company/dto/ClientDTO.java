package com.loan.company.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @org.hibernate.validator.constraints.br.CPF
    private String CPF;

    @NotEmpty
    private String RG;

    @Valid
    @NotEmpty
    private List<AddressDTO> addresses;

    @NotEmpty
    private double income;

    @NotEmpty
    private String password;


}
