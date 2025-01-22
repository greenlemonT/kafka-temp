package kafka.ordermodule.service;

import kafka.ordermodule.dto.DeliveryRequest;
import kafka.ordermodule.dto.DeliveryResponse;
import kafka.ordermodule.dto.PaymentFailedEvent;
import kafka.ordermodule.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderConsumer {

    private final OrderService orderService;

    @KafkaListener(topics = "payment-create-response", groupId = "order-group")
    public void handlePaymentResponse(PaymentResponse response) {
        orderService.updateOrderStatus(response.getOrderId(), "PAYMENT_COMPLETED");
        orderService.sendDeliveryRequest(response);
    }

    @KafkaListener(topics = "payment-failed", groupId = "order-group")
    public void handlePaymentFailed(PaymentFailedEvent event) {
        orderService.updateOrderStatus(event.getOrderId(), "CANCELED");
    }

    @KafkaListener(topics = "delivery-create-response", groupId = "order-group")
    public void handleDeliveryResponse(DeliveryResponse response) {
        orderService.updateOrderStatus(response.getOrderId(), "DELIVERY_READY");
    }
}
