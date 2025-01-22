package kafka.ordermodule.service;

import kafka.ordermodule.dto.DeliveryRequest;
import kafka.ordermodule.dto.OrderRequest;
import kafka.ordermodule.dto.PaymentRequest;
import kafka.ordermodule.dto.PaymentResponse;
import kafka.ordermodule.entity.Order;
import kafka.ordermodule.entity.OrderItem;
import kafka.ordermodule.entity.OrderStatus;
import kafka.ordermodule.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    public void createOrder(OrderRequest request) {
        List<OrderItem> orderItems = (request.getItems() != null ?
                request.getItems().stream()
                        .map(item -> new OrderItem(null, item.getProductId(), item.getQuantity(), item.getPrice()))
                        .collect(Collectors.toList()) :
                Collections.emptyList());

        Order order = new Order(
                request.getOrderId(),
                request.getUsername(),
                OrderStatus.PENDING,
                request.getTotalAmount(),
                orderItems
        );

        orderRepository.save(order);

        PaymentRequest paymentRequest = new PaymentRequest(
                request.getOrderId(),
                request.getUsername(),
                request.getTotalAmount()
        );
        orderProducer.sendPaymentRequest(paymentRequest);
    }

    // 주문 상태 업데이트
    public void updateOrderStatus(String orderId, String status) {
        // Order 엔티티를 조회
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found for id: " + orderId));

        // 상태 업데이트
        order.setStatus(OrderStatus.valueOf(status)); // Enum으로 변환하여 설정
        orderRepository.save(order); // 변경 사항 저장
    }

    // 배송 요청 발행
    public void sendDeliveryRequest(PaymentResponse response) {
        // 배송 요청 생성
        DeliveryRequest deliveryRequest = new DeliveryRequest(
                response.getOrderId(),
                response.getUsername(),
                "Sample Address" // 배송 주소를 여기에 설정
        );

        // 배송 요청 메시지 발행
        orderProducer.sendDeliveryRequest(deliveryRequest);
    }
}