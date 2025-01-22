package kafka.ordermodule.service;


import kafka.ordermodule.dto.DeliveryRequest;
import kafka.ordermodule.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendPaymentRequest(PaymentRequest request) {
        kafkaTemplate.send("payment-create-request", request.getOrderId(), request);
    }

    public void sendDeliveryRequest(DeliveryRequest request) {
        kafkaTemplate.send("delivery-create-request", request.getOrderId(), request);
    }
}
