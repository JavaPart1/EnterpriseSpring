package eu.noelvaes.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="BeerOrders")
public class BeerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;

    @OneToMany
    @JoinColumn(name = "BeerOrderId")
    private List<Beers> beers = new ArrayList<>();

    public BeerOrder() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Beers> getBeers() {
        return beers;
    }

    public void setBeers(List<Beers> beers) {
        this.beers = beers;
    }
}