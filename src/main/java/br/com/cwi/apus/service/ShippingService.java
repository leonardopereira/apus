package br.com.cwi.apus.service;

import br.com.cwi.apus.external.cetus.request.ShippingExternalRequest;
import br.com.cwi.apus.external.cetus.response.ShippingExternalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class ShippingService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${myapp.external.cetus.url}")
    private String cetusUrl;

    public ResponseEntity<ShippingExternalResponse> calculate(ShippingExternalRequest shippingExternalRequest) {
        URI uri = UriComponentsBuilder.fromHttpUrl(cetusUrl + "/api/cetus/shipping").build().toUri();

        try {
            ShippingExternalResponse shippingExternalResponse = restTemplate.postForObject(uri, shippingExternalRequest, ShippingExternalResponse.class);
            return ResponseEntity.ok(shippingExternalResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
