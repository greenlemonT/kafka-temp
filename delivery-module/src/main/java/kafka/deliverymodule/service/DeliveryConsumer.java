package kafka.deliverymodule.service;

import kafka.deliverymodule.dto.DeliveryRequest;
import kafka.deliverymodule.dto.DeliveryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryConsumer {

    private final DeliveryService deliveryService;

    @KafkaListener(topics = "delivery-create-request", groupId = "delivery-group")
    public void handleDeliveryRequest(DeliveryRequest request) {
        try {
            // 배송 요청 처리
            deliveryService.processDelivery(request);
        } catch (Exception e) {
            log.error("Failed to handle delivery request for orderId: {}", request.getOrderId(), e);
        }
    }
}