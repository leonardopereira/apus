package br.com.cwi.apus.service;

import br.com.cwi.apus.domain.Product;
import br.com.cwi.apus.repository.ProductRepository;
import br.com.cwi.apus.response.ProductDetailResponse;
import br.com.cwi.apus.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> {
           ProductResponse productResponse = new ProductResponse(product.getId(), product.getDescription());
           return productResponse;
        }).collect(Collectors.toList());
    }

    public ResponseEntity<ProductDetailResponse> detail(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(new ProductDetailResponse(product.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
