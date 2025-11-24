package co.edu.uvpalmira.urss.Backend.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uvpalmira.urss.Backend.Model.Order;
//import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
        List<Order> findAllByCreationTimestampBetweenOrderByCreationTimestampDesc(LocalDateTime start, LocalDateTime end);
}
