package kafka.deliverymodule.service;


import kafka.deliverymodule.dto.DeliveryRequest;
import kafka.deliverymodule.dto.DeliveryResponse;
import kafka.deliverymodule.entity.Delivery;
import kafka.deliverymodule.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryProducer deliveryProducer;

    public void createDelivery(DeliveryRequest request) {
        try {
            // 배송 엔티티 생성
            Delivery delivery = new Delivery(
                    UUID.randomUUID().toString(), // 배송 ID
                    request.getOrderId(),
                    request.getUsername(),
                    request.getRecipientAddress(),
                    "DELIVERY_READY"
            );

            // DB에 저장
            deliveryRepository.save(delivery);

            // 성공 응답 메시지 발행
            DeliveryResponse response = new DeliveryResponse(
                    delivery.getOrderId(),
                    delivery.getDeliveryId(),
                    delivery.getStatus()
            );
            deliveryProducer.sendDeliveryResponse(response);
            log.info("Delivery created successfully for orderId: {}", request.getOrderId());
        } catch (Exception e) {
            log.error("Failed to create delivery for orderId: {}", request.getOrderId(), e);
            throw new RuntimeException("Delivery creation failed", e);
        }
    }
    public DeliveryResponse processDelivery(DeliveryRequest request) {
        try {
            // 배송 엔티티 생성
            Delivery delivery = new Delivery(
                    UUID.randomUUID().toString(), // 생성된 배송 ID
                    request.getOrderId(),
                    request.getUsername(),
                    request.getRecipientAddress(),
                    "DELIVERY_READY" // 초기 상태 설정
            );

            // 배송 데이터 저장
            deliveryRepository.save(delivery);

            // 로그 출력
            log.info("Delivery processed successfully for orderId: {}", request.getOrderId());

            // 성공 응답 생성
            return new DeliveryResponse(
                    delivery.getOrderId(),
                    delivery.getDeliveryId(),
                    delivery.getStatus()
            );
        } catch (Exception e) {
            // 예외 처리
            log.error("Failed to process delivery for orderId: {}", request.getOrderId(), e);
            throw new RuntimeException("Delivery processing failed", e);
        }
    }
}
