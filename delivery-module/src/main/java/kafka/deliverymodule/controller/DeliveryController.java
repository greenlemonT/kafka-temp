package kafka.deliverymodule.controller;


import kafka.deliverymodule.dto.DeliveryRequest;
import kafka.deliverymodule.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public ResponseEntity<String> createDelivery(@RequestBody DeliveryRequest request) {
        deliveryService.createDelivery(request);
        return ResponseEntity.ok("Delivery request received");
    }
}
