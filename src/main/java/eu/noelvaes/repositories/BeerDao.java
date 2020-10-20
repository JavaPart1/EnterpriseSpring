package eu.noelvaes.repositories;

import java.util.List;

public interface BeerDao {
    public String getBeersById(int id);
    public void setStock(int id, int stock);
    public List<String> getBeersByAlcohol(float alcohol);
}
