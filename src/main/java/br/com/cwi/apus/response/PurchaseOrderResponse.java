package br.com.cwi.apus.response;

import br.com.cwi.apus.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PurchaseOrderResponse {
    private Long orderId;
    private Status status;
    private double totalItems;
    private BasketShippingResponse shipping;
    private String paymentId;
    private double total;
    private int volume;
    private List<ProductOrderResponse> items;
}
