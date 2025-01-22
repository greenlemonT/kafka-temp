package kafka.paymentmodule.service;


import kafka.paymentmodule.dto.PaymentFailedEvent;
import kafka.paymentmodule.dto.PaymentRequest;
import kafka.paymentmodule.dto.PaymentResponse;
import kafka.paymentmodule.entity.Payment;
import kafka.paymentmodule.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentProducer paymentProducer;

    public PaymentResponse processPayment(PaymentRequest request) {
        try {
            // 결제 처리 로직 (예: 가상 결제 승인)
            String paymentId = UUID.randomUUID().toString();

            // Payment 엔티티 저장
            Payment payment = new Payment(
                    paymentId,
                    request.getOrderId(),
                    request.getUsername(),
                    request.getAmount(),
                    "COMPLETED" // 성공 상태로 설정
            );
            paymentRepository.save(payment);

            log.info("Payment processed successfully for orderId: {}", request.getOrderId());

            // 성공 응답 생성
            PaymentResponse response = new PaymentResponse(
                    request.getOrderId(),
                    "COMPLETED",
                    paymentId,
                    request.getUsername()
            );

            // Kafka 결제 성공 메시지 발행
            paymentProducer.sendPaymentResponse(response);

            return response;
        } catch (Exception e) {
            log.error("Payment processing failed for orderId: {}", request.getOrderId(), e);

            // 결제 실패 이벤트 생성
            PaymentFailedEvent failedEvent = new PaymentFailedEvent(request.getOrderId());

            // Kafka 결제 실패 메시지 발행
            paymentProducer.sendPaymentFailed(failedEvent);

            throw new RuntimeException("Payment processing failed");
        }
    }
}