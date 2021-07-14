package br.com.cwi.apus.service;

import br.com.cwi.apus.domain.Basket;
import br.com.cwi.apus.domain.Customer;
import br.com.cwi.apus.domain.Product;
import br.com.cwi.apus.repository.BasketRepository;
import br.com.cwi.apus.repository.ProductRepository;
import br.com.cwi.apus.request.CustomerAddressRequest;
import br.com.cwi.apus.request.CustomerIdentityRequest;
import br.com.cwi.apus.request.CustomerPaymentRequest;
import br.com.cwi.apus.request.ProductRequest;
import br.com.cwi.apus.response.BasketResponse;
import br.com.cwi.apus.response.OrderCheckoutResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    public BasketResponse create() {
        Basket basket = basketRepository.save(new Basket());
        return new BasketResponse(basket.getId());
    }

    public ResponseEntity<Basket> addProduct(Long id, ProductRequest productRequest) {
        Optional<Basket> basket = basketRepository.findById(id);

        if (basket.isPresent()) {
            Optional<Product> product = productRepository.findById(productRequest.getId());
            if (product.isPresent()) {
                if (basket.get().getProducts().contains(product.get())) {
                    product.get().setQuantity(productRequest.getQuantity());
                } else {
                    basket.get().getProducts().add(product.get());
                    // product.get().setBasket(basket.get());
                }
                basketRepository.save(basket.get());

                return ResponseEntity.ok().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Basket> updateIdentity(Long id, CustomerIdentityRequest customerIdentityRequest) {
        Optional<Basket> basket = basketRepository.findById(id);

        if (basket.isPresent()) {
            if (basket.get().getCustomer() != null) {
                basket.get().getCustomer().setEmail(customerIdentityRequest.getEmail());
                basket.get().getCustomer().setName(customerIdentityRequest.getName());
            } else {
                basket.get().setCustomer(new Customer(customerIdentityRequest.getEmail(), customerIdentityRequest.getName()));
            }

            basketRepository.save(basket.get());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Basket> updateAddress(Long id, CustomerAddressRequest customerAddressRequest) {
        Optional<Basket> basket = basketRepository.findById(id);

        if (basket.isPresent()) {
            if (basket.get().getCustomer() != null) {
                basket.get().getCustomer().setZip(customerAddressRequest.getZip());
                basket.get().getCustomer().setAddress(customerAddressRequest.getAddress());
            } else {
                Customer customer = new Customer();
                customer.setZip(customerAddressRequest.getZip());
                customer.setAddress(customerAddressRequest.getAddress());
                basket.get().setCustomer(customer);
            }

            basketRepository.save(basket.get());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Basket> updatePayment(Long id, CustomerPaymentRequest customerPaymentRequest) {
        Optional<Basket> basket = basketRepository.findById(id);

        if (basket.isPresent()) {
            if (basket.get().getCustomer() != null) {
                basket.get().getCustomer().setCard(customerPaymentRequest.getCard());
            } else {
                basket.get().setCustomer(new Customer(customerPaymentRequest.getCard()));
            }

            basketRepository.save(basket.get());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<OrderCheckoutResponse> checkout(Long id) {
        Optional<Basket> basket = basketRepository.findById(id);

        if (basket.isPresent()) {

        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Basket> findById(Long id) {
        Optional<Basket> basket = basketRepository.findById(id);

        if (basket.isPresent()) {
            return ResponseEntity.ok(basket.get());
        }

        return ResponseEntity.notFound().build();
    }
}
