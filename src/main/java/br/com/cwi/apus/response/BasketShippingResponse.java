package br.com.cwi.apus.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class BasketShippingResponse {
    private double total;
    private Date time;
    private String quotationId;
}
