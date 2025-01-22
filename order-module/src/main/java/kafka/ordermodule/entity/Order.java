package kafka.ordermodule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    private String orderId; // 주문 ID

    @Column(name = "username", nullable = false)
    private String username; // 사용자 이름 또는 ID

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태 (Enum으로 관리)

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount; // 주문 총액

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items; // 주문 항목 리스트
}
