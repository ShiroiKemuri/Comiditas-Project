package co.edu.uvpalmira.urss.Backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaleItemResponseDto {
    private String productName;
    private int quantity;
}
