package br.com.cwi.apus.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long id;

    private double totalItems;

    private double shipping;

    private Date time;

    private double total;

    private int volume;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "baskets_products", joinColumns = @JoinColumn(name = "basket_id", referencedColumnName = "basket_id")
            , inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"))
    private List<Product> products = new ArrayList<>();
}
