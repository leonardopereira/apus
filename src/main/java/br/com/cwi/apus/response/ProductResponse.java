package br.com.cwi.apus.response;

import br.com.cwi.apus.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String description;

    public static Page<ProductResponse> convert(Page<Product> products) {
        return products.map(product -> {
            ProductResponse productResponse = new ProductResponse(product.getId(), product.getDescription());
            return productResponse;
        });
    }
}
