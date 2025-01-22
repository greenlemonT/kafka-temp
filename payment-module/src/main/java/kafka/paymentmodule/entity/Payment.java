package kafka.paymentmodule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @Column(name = "payment_id")
    private String paymentId; // 결제 ID

    @Column(name = "order_id", nullable = false)
    private String orderId; // 주문 ID

    @Column(name = "username", nullable = false)
    private String username; // 사용자 이름

    @Column(name = "amount", nullable = false)
    private BigDecimal amount; // 결제 금액

    @Column(name = "status", nullable = false)
    private String status; // 결제 상태 (COMPLETED, FAILED)
}
