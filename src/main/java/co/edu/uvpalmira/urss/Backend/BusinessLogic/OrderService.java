package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import co.edu.uvpalmira.urss.Backend.DTO.OrderDTO;
import co.edu.uvpalmira.urss.Backend.DTO.OrderItemDTO;
import co.edu.uvpalmira.urss.Backend.Model.Order;
import co.edu.uvpalmira.urss.Backend.IRepository.OrderRepo;
import co.edu.uvpalmira.urss.Backend.Model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd,MM,yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH,mm");

    public List<OrderDTO> getTodaysOrders() {
        LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        List<Order> orders = orderRepository.findAllByCreationTimestampBetweenOrderByCreationTimestampDesc(startOfDay, endOfDay);

        return orders.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private OrderDTO convertToDto(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setOrderNumber(order.getId());
        dto.setCustomerNumber(order.getCustomerNumber());
        dto.setTotalToPay(order.getTotalToPay());
        dto.setDate(order.getCreationTimestamp().format(DATE_FORMATTER));
        dto.setTime(order.getCreationTimestamp().format(TIME_FORMATTER));

        List<OrderItemDTO> itemDTOs = order.getItems().stream()
                .map(this::convertItemToDto)
                .collect(Collectors.toList());
        dto.setItems(itemDTOs);

        return dto;
    }

    private OrderItemDTO convertItemToDto(OrderItem item) {
        return new OrderItemDTO(item.getDishName(), item.getQuantity());
    }
}
