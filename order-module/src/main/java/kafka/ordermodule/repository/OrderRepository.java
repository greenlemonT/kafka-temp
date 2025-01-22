package kafka.ordermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kafka.ordermodule.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
