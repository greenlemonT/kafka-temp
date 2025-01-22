package kafka.ordermodule.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequest {
    private String orderId;
    private String username;
    private String recipientAddress;
}
