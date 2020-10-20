package eu.noelvaes.repositories;

import eu.noelvaes.domain.Beers;

import java.util.List;

public interface BeerRepository {
    public Beers getBeerById(int id);
}
