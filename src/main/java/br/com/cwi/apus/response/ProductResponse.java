package br.com.cwi.apus.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String description;
}
