package eu.noelvaes.repositories;

import eu.noelvaes.domain.Beers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository{
    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public Beers getBeerById(int id) {
        return em.find(Beers.class,id);
    }
}
