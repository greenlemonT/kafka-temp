package kafka.ordermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String orderId; // 주문 ID
    private String username; // 사용자 이름
    private BigDecimal totalAmount; // 주문 총액
    private List<OrderItemRequest> items; // 주문 항목 리스트
}