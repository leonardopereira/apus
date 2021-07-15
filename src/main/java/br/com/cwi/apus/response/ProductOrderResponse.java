package br.com.cwi.apus.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductOrderResponse {
    private Long id;
    private int quantity;
    private int volume;
}
