package com.loan.company.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String district;

    @Column
    private String complement;

    @Column(nullable = false)
    private String CEP;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String UF;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;




}
