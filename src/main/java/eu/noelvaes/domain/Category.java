package eu.noelvaes.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int catId;
    private String catName;

    @OneToMany(mappedBy = "category")
    private List<Beers> beers = new ArrayList<>();

    public Category() {
    }

    public Category(String catName) {
        this.catName = catName;
    }

    public int getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<Beers> getBeers() {
        return beers;
    }

    public void setBeers(List<Beers> beers) {
        this.beers = beers;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                '}';
    }
}