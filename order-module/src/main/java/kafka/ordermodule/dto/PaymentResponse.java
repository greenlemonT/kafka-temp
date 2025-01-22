package kafka.ordermodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private String orderId;
    private String status; // COMPLETED, FAILED
    private String paymentId;
    private String username;
}
