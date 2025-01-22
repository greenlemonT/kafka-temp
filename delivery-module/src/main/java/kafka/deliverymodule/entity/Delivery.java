package kafka.deliverymodule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deliveries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @Column(name = "delivery_id")
    private String deliveryId; // 배송 ID

    @Column(name = "order_id", nullable = false)
    private String orderId; // 주문 ID

    @Column(name = "username", nullable = false)
    private String username; // 사용자 이름

    @Column(name = "recipient_address", nullable = false)
    private String recipientAddress; // 배송 주소

    @Column(name = "status", nullable = false)
    private String status; // 배송 상태 (DELIVERY_READY, DELIVERY_FAILED 등)
}
