package br.com.cwi.apus.controller;

import br.com.cwi.apus.response.ProductDetailResponse;
import br.com.cwi.apus.response.ProductResponse;
import br.com.cwi.apus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductResponse> list(@RequestParam(required = false) String description, Pageable pagination) {
        return productService.findAll(description, pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> detail(@PathVariable Long id) {
        return productService.detail(id);
    }
}
