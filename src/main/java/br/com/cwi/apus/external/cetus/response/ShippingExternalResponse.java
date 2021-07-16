package br.com.cwi.apus.external.cetus.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ShippingExternalResponse {

    private String id;
    private double price;
    private Date time;
}
