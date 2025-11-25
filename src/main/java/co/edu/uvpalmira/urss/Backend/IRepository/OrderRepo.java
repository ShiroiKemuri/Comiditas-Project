package co.edu.uvpalmira.urss.Backend.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uvpalmira.urss.Backend.Model.Order;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
        List<Order> findByDateOrderByTimeDesc(LocalDate date);
}
