package br.com.cwi.apus.request;

import lombok.Getter;

@Getter
public class CustomerAddressRequest {
    private String zip;
    private String address;
}
