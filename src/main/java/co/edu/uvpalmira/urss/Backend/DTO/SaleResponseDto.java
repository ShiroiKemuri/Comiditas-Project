package co.edu.uvpalmira.urss.Backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SaleResponseDto {
    private Long saleId;
    private LocalDateTime saleDate;
    private double totalAmount;
    private List<SaleItemResponseDto> items;
}