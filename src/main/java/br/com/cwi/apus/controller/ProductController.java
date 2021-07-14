package br.com.cwi.apus.controller;

import br.com.cwi.apus.response.ProductDetailResponse;
import br.com.cwi.apus.response.ProductResponse;
import br.com.cwi.apus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponse> list() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponse> detail(@PathVariable Long id) {
        return productService.detail(id);
    }
}
