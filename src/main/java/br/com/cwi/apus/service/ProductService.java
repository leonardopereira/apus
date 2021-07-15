package br.com.cwi.apus.service;

import br.com.cwi.apus.domain.Product;
import br.com.cwi.apus.repository.ProductRepository;
import br.com.cwi.apus.response.ProductDetailResponse;
import br.com.cwi.apus.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<ProductResponse> findAll(String description, Pageable pagination) {
        if (description == null) {
            Page<Product> products = productRepository.findAll(pagination);
            return ProductResponse.convert(products);
        } else {
            Page<Product> products = productRepository.findByDescriptionContainingIgnoreCase(description, pagination);
            return ProductResponse.convert(products);
        }
    }

    public ResponseEntity<ProductDetailResponse> detail(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(new ProductDetailResponse(product.get()));
        }

        return ResponseEntity.notFound().build();
    }
}
