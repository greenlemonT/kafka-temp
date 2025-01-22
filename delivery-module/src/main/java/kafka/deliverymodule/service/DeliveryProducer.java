package kafka.deliverymodule.service;

import kafka.deliverymodule.dto.DeliveryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendDeliveryResponse(DeliveryResponse response) {
        kafkaTemplate.send("delivery-create-response", response.getOrderId(), response);
    }
}
