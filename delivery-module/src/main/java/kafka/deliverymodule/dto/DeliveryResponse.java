package kafka.deliverymodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponse {
    private String orderId; // 주문 ID
    private String deliveryId; // 배송 ID
    private String status; // 배송 상태
}
