package kafka.ordermodule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 자동 생성 ID

    @Column(name = "product_id", nullable = false)
    private String productId; // 상품 ID

    @Column(name = "quantity", nullable = false)
    private int quantity; // 상품 수량

    @Column(name = "price", nullable = false)
    private BigDecimal price; // 상품 가격
}
