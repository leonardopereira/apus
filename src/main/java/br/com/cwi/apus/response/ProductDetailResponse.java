package br.com.cwi.apus.response;

import br.com.cwi.apus.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDetailResponse {
    private Long id;
    private String description;
    private int quantity;
    private int volume;
    private double price;

    public ProductDetailResponse(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.volume = product.getVolume();
        this.price = product.getPrice();
    }
}
