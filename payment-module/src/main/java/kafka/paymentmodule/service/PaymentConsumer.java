package kafka.paymentmodule.service;

import kafka.paymentmodule.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentConsumer {

    private final PaymentService paymentService;

    @KafkaListener(topics = "payment-create-request", groupId = "payment-group")
    public void handlePaymentRequest(PaymentRequest request) {
        paymentService.processPayment(request);
    }
}