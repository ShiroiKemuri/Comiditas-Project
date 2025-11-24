package co.edu.uvpalmira.urss.Backend.Controller;

import co.edu.uvpalmira.urss.Backend.DTO.OrderDTO;
import co.edu.uvpalmira.urss.Backend.BusinessLogic.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/today")
    // En un futuro, con Spring Security, añadirías: @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<OrderDTO>> getTodaysOrders() {
        return ResponseEntity.ok(orderService.getTodaysOrders());
    }
}