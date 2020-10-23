package eu.noelvaes;

import eu.noelvaes.domain.Beers;
import eu.noelvaes.repositories.BeerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(BeerApp.class, args);
        BeerRepository br = ctx.getBean("BeerRepository",BeerRepository.class);
        System.out.println(br.getBeerById(20).toString());
    }
}
