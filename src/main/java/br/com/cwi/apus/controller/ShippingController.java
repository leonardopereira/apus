package br.com.cwi.apus.controller;

import br.com.cwi.apus.external.cetus.request.ShippingExternalRequest;
import br.com.cwi.apus.external.cetus.response.ShippingExternalResponse;
import br.com.cwi.apus.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public ResponseEntity<ShippingExternalResponse> calculate(@RequestBody ShippingExternalRequest shippingExternalRequest) {
        return shippingService.calculate(shippingExternalRequest);
    }
}
