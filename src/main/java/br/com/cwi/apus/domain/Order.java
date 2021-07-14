package br.com.cwi.apus.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
}
