package eu.noelvaes.repositories;

import eu.noelvaes.domain.Beers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BeerRepository extends JpaRepository<Beers,Integer> {
    public default Beers getBeerById(int id){
     return findById(id).orElse(null);
    }

}
