package br.com.cwi.apus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String email;

    private String name;

    private String zip;

    private String address;

    private String card;

    public Customer(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Customer(String card) {
        this.card = card;
    }
}
