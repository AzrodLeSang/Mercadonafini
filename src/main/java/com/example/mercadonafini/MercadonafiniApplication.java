package com.example.mercadonafini;

import com.example.mercadonafini.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
public class MercadonafiniApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MercadonafiniApplication.class, args);
    }

    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public void run(String... args) throws Exception {

    }


}
