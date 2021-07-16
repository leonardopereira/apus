package br.com.cwi.apus.controller;

import br.com.cwi.apus.domain.Basket;
import br.com.cwi.apus.request.CustomerAddressRequest;
import br.com.cwi.apus.request.CustomerIdentityRequest;
import br.com.cwi.apus.request.CustomerPaymentRequest;
import br.com.cwi.apus.request.ProductRequest;
import br.com.cwi.apus.response.BasketResponse;
import br.com.cwi.apus.response.PurchaseOrderCheckoutResponse;
import br.com.cwi.apus.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BasketResponse> create(UriComponentsBuilder uriComponentsBuilder) {
        return basketService.create(uriComponentsBuilder);
    }

    @PutMapping("/{id}/item")
    @Transactional
    public ResponseEntity<Basket> addProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        return basketService.addProduct(id, productRequest);
    }

    @PutMapping("/{id}/identity")
    @Transactional
    public ResponseEntity<Basket> updateIdentity(@PathVariable Long id, @RequestBody CustomerIdentityRequest customerIdentityRequest) {
        return basketService.updateIdentity(id, customerIdentityRequest);
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<Basket> updateAddress(@PathVariable Long id, @RequestBody CustomerAddressRequest customerAddressRequest) {
        return basketService.updateAddress(id, customerAddressRequest);
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Basket> updatePayment(@PathVariable Long id, @RequestBody CustomerPaymentRequest customerPaymentRequest) {
        return basketService.updatePayment(id, customerPaymentRequest);
    }

    @PutMapping("/{id}/checkout")
    public ResponseEntity<PurchaseOrderCheckoutResponse> checkout(@PathVariable Long id) {
        return basketService.checkout(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> findById(@PathVariable Long id) {
        return basketService.findById(id);
    }
}
