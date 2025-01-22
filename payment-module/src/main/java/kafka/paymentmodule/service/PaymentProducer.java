package kafka.paymentmodule.service;

import kafka.paymentmodule.dto.PaymentFailedEvent;
import kafka.paymentmodule.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPaymentResponse(PaymentResponse response) {
        kafkaTemplate.send("payment-create-response", response.getOrderId(), response);
    }

    public void sendPaymentFailed(PaymentFailedEvent event) {
        kafkaTemplate.send("payment-failed", event.getOrderId(), event);
    }
}