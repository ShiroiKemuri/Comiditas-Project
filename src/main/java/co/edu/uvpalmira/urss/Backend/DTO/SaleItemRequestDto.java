package co.edu.uvpalmira.urss.Backend.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleItemRequestDto {
    private Long productId;
    private int quantity;
}
