package br.com.cwi.apus.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String description;

    private int quantity;

    private int volume;

    private double price;

}
