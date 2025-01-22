package kafka.ordermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private String productId; // 상품 ID
    private int quantity; // 상품 수량
    private BigDecimal price; // 상품 가격
}