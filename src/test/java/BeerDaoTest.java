import eu.noelvaes.repositories.BeerDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeerDaoTest {
    @Autowired
    private BeerDao dao;

    @Test
    public void getBeerById(){
        String beer = dao.getBeersById(1);
        Assertions.assertEquals("Testbeer 7.0 2.75 100", beer);
    }
}
