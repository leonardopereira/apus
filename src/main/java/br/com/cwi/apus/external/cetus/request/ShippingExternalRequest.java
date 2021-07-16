package br.com.cwi.apus.external.cetus.request;

import lombok.Getter;

@Getter
public class ShippingExternalRequest {

    private String zipOrigin;
    private String zipDestination;
    private int volume;
}
