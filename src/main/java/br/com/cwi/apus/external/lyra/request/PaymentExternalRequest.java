package br.com.cwi.apus.external.lyra.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentExternalRequest {

    private String id;
    private double total;
    private String card;
}
