package br.com.cwi.apus.domain;

import br.com.cwi.apus.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status = Status.CRIADO;

    @OneToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public PurchaseOrder(Basket basket) {
        this.basket = basket;
    }

}
