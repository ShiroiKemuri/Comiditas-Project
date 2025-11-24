package co.edu.uvpalmira.urss.Backend.DTO;
import java.math.BigDecimal;
import java.util.List;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor  
public class OrderDTO {
 
    private Long orderNumber;
    private String customerNumber;
    private List<OrderItemDTO> items;
    private BigDecimal totalToPay;
    private String date; // Formato DD,MM,AAAA
    private String time;
}
