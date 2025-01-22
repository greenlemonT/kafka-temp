package kafka.ordermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponse {
    private String orderId;
    private String deliveryId;
    private String status;
}
