package com.loan.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String street;

    private String number;

    private String district;

    private String complement;

    private String CEP;

    private String city;

    private String UF;



}
