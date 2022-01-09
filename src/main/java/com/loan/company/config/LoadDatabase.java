package com.loan.company.config;

import com.loan.company.entities.Address;
import com.loan.company.entities.Client;
import com.loan.company.entities.Loan;
import com.loan.company.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);



    @Bean
    CommandLineRunner initDatabase(ClientRepository repository){
        List<Address> addr = new ArrayList<>();
        List<Loan> loan = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String date = "16/08/2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        Loan loan1 = Loan.builder().value(12L).dateInstallments(localDate).installments(60).build();

        Address address = Address.builder().street("Rua lavinia").number("45")
                .CEP("29220-750").city("Guarapari").district("Centro").UF("ES").build();

        loan.add(loan1);
        addr.add(address);
        System.out.println(addr);

        Client client = Client.builder().name("José Armando").CPF("132.621.297-47").RG("5445454")
                .income(1000L).email("joserarmando@gmail.com").addresses(addr)
                .password("9945656").loans(loan).build();

        return args -> {
            log.info("Preloading " + repository.save(client));

        };
    }
}
