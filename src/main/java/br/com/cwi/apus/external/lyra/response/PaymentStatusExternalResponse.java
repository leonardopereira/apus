package br.com.cwi.apus.external.lyra.response;

import br.com.cwi.apus.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentStatusExternalResponse {

    private Long id;
    private Status status;
}
