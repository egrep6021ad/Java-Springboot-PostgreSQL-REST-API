package com.example.demo.client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* Instantiate two initial DEMO patients to D.B. (clear before launch) */
@Configuration
public class NewClientConfig {
/*This annotation is critical for initial DB population */
    @Bean
    CommandLineRunner commandLineRunner(
            NewClientRepository repository){
        return args -> {
            Client Ricky =   new Client("0123456789","khalfanijabari@gmail.com", "Ricky Booby",
                    "my damn roof man", 1000, 6,null, "Looking for an estimate on a few diffent tasks"
            );
            Ricky.setFreeQuote(350.00);
            repository.save(Ricky);
        };
    }
}
