package co.edu.uvpalmira.urss.Backend.DTO;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CreateSaleRequestDto {
    private List<SaleItemRequestDto> items;
    private double totalAmountPaid;
}
