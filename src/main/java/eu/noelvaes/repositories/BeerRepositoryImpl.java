package eu.noelvaes.repositories;

import eu.noelvaes.domain.Beers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository{
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Beers getBeerById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Beers beer = em.find(Beers.class, id);
            tx.commit();
            return beer;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }finally {
            if (em != null){
                em.close();
            }
        }
    }


}
