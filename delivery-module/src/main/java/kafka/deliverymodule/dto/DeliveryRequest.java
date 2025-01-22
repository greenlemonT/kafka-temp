package kafka.deliverymodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequest {
    private String orderId; // 주문 ID
    private String username; // 사용자 이름
    private String recipientAddress; // 배송 주소
}
