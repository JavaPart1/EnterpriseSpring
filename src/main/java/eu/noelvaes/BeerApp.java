package eu.noelvaes;

import eu.noelvaes.domain.Beers;
import eu.noelvaes.repositories.BeerDao;
import eu.noelvaes.repositories.BeerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeerApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(BeerApp.class, args);
        BeerRepository br = ctx.getBean("beerRepository", BeerRepository.class);
        Beers beer = br.getBeerById(20);
        System.out.println(br.getBeerById(20).toString());

        //BeerDao dao = ctx.getBean("beerDao", BeerDao.class);
        //dao.setStock(10, 200);


    }
}
