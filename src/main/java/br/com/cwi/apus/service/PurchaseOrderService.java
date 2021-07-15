package br.com.cwi.apus.service;

import br.com.cwi.apus.domain.PurchaseOrder;
import br.com.cwi.apus.repository.PurchaseOrderRepository;
import br.com.cwi.apus.response.BasketShippingResponse;
import br.com.cwi.apus.response.ProductOrderResponse;
import br.com.cwi.apus.response.PurchaseOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public ResponseEntity<PurchaseOrderResponse> findById(Long id) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderRepository.findById(id);

        if (purchaseOrder.isPresent()) {
            return ResponseEntity.ok(new PurchaseOrderResponse(purchaseOrder.get().getId(), purchaseOrder.get().getStatus(), purchaseOrder.get().getBasket().getTotalItems(),
                    new BasketShippingResponse(purchaseOrder.get().getBasket().getTotal(), purchaseOrder.get().getBasket().getTime(), "11111abcde"), "22222abcde",
                    purchaseOrder.get().getBasket().getTotal(), purchaseOrder.get().getBasket().getVolume(), purchaseOrder.get().getBasket().getProducts().stream().map(product -> {
                ProductOrderResponse productOrderResponse = new ProductOrderResponse(product.getId(), product.getQuantity(), product.getVolume());
                return productOrderResponse;
            }).collect(Collectors.toList())));
        }

        return ResponseEntity.notFound().build();
    }
}
