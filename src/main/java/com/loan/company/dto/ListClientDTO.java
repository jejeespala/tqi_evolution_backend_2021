package com.loan.company.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListClientDTO {

    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @org.hibernate.validator.constraints.br.CPF
    private String CPF;

    @NotNull
    private String RG;

    private List<ListAddressDTO> addresses;

    @NotNull
    private Long income;

    @NotNull
    private String password;


}
