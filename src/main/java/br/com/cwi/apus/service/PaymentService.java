package br.com.cwi.apus.service;

import br.com.cwi.apus.external.lyra.request.PaymentExternalRequest;
import br.com.cwi.apus.external.lyra.response.PaymentExternalResponse;
import br.com.cwi.apus.external.lyra.response.PaymentStatusExternalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${myapp.external.lyra.url}")
    private String lyraUrl;

    public ResponseEntity<PaymentExternalResponse> pay(PaymentExternalRequest paymentExternalRequest) {
        URI uri = UriComponentsBuilder.fromHttpUrl(lyraUrl + "/api/lyra/payment").build().toUri();

        try {
            PaymentExternalResponse paymentExternalResponse = restTemplate.postForObject(uri, paymentExternalRequest, PaymentExternalResponse.class);
            return ResponseEntity.ok(paymentExternalResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    public ResponseEntity<PaymentStatusExternalResponse> getStatus(Long id) {
        String url = lyraUrl + "/api/lyra/payment/" + id + "/status";

        try {
            PaymentStatusExternalResponse paymentStatusExternalResponse = restTemplate.getForObject(url, PaymentStatusExternalResponse.class);
            return ResponseEntity.ok(paymentStatusExternalResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
