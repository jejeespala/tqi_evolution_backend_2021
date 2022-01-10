package com.loan.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListAddressDTO {

    private Long id;

    @NotNull
    private String street;

    @NotNull
    private String number;

    @NotNull
    private String district;

    private String complement;

    @NotNull
    private String CEP;

    @NotNull
    private String city;

    @NotNull
    private String UF;




}
