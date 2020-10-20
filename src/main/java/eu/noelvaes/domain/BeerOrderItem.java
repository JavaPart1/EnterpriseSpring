package eu.noelvaes.domain;

import javax.persistence.*;

@Entity
@Table(name = "BeerOrderItems")
public class BeerOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "Number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "BeerId")
    private Beers beer;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public Beers getBeer() {
        return beer;
    }

    public void setBeer(Beers beer) {
        this.beer = beer;
    }
}
