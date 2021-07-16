package br.com.cwi.apus.controller;

import br.com.cwi.apus.external.lyra.request.PaymentExternalRequest;
import br.com.cwi.apus.external.lyra.response.PaymentExternalResponse;
import br.com.cwi.apus.external.lyra.response.PaymentStatusExternalResponse;
import br.com.cwi.apus.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentExternalResponse> pay(@RequestBody PaymentExternalRequest paymentExternalRequest) {
        return paymentService.pay(paymentExternalRequest);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<PaymentStatusExternalResponse> getStatus(@PathVariable Long id) {
        return paymentService.getStatus(id);
    }
}
