package br.com.cwi.apus.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PurchaseOrderCheckoutResponse {
    private Long orderId;
}
