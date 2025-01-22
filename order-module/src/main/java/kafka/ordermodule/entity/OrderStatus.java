package kafka.ordermodule.entity;

public enum OrderStatus {
    PENDING,           // 주문 대기 중
    PAYMENT_COMPLETED, // 결제 완료
    DELIVERY_READY,    // 배송 준비 완료
    CANCELED           // 주문 취소
}
