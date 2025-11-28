package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import co.edu.uvpalmira.urss.Backend.DTO.SaleItemResponseDto;
import co.edu.uvpalmira.urss.Backend.DTO.SaleResponseDto;
import co.edu.uvpalmira.urss.Backend.DTO.CreateSaleRequestDto;
import co.edu.uvpalmira.urss.Backend.DTO.SaleItemRequestDto;
import co.edu.uvpalmira.urss.Backend.IRepository.ProductoRepo;
import co.edu.uvpalmira.urss.Backend.IRepository.SellsRepo;
import co.edu.uvpalmira.urss.Backend.Model.Producto;
import co.edu.uvpalmira.urss.Backend.Model.Sale;
import co.edu.uvpalmira.urss.Backend.Model.SaleItem;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellsService {

    @Autowired
    private SellsRepo saleRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Transactional
    public Sale createSale(CreateSaleRequestDto saleRequest) {
        Sale newSale = new Sale();
        newSale.setSaleDate(LocalDateTime.now());
        newSale.setTotalAmount(saleRequest.getTotalAmountPaid());

        List<SaleItem> saleItems = new ArrayList<>();
        for (SaleItemRequestDto itemDto : saleRequest.getItems()) {
            Producto product = productoRepo.findById(itemDto.getProductId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Producto no encontrado con id: " + itemDto.getProductId()));

            SaleItem saleItem = new SaleItem();
            saleItem.setProduct(product);
            saleItem.setQuantity(itemDto.getQuantity());
            saleItem.setPricePerUnit(product.getPrice());
            saleItem.setSale(newSale);
            saleItems.add(saleItem);
        }

        newSale.setItems(saleItems);
        return saleRepo.save(newSale);
    }

    public Sale getSaleById(Long id) {
        return saleRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Venta no encontrada con id: " + id));
    }

    public List<SaleResponseDto> getAllSales() {
        List<Sale> sales = saleRepo.findAll();
        return sales.stream().map(this::mapToSaleResponseDto).collect(Collectors.toList());
    }

    private SaleResponseDto mapToSaleResponseDto(Sale sale) {
        SaleResponseDto dto = new SaleResponseDto();
        dto.setSaleId(sale.getId());
        dto.setSaleDate(sale.getSaleDate());
        dto.setTotalAmount(sale.getTotalAmount());

        List<SaleItemResponseDto> itemDtos = sale.getItems().stream()
                .map(item -> new SaleItemResponseDto(
                        item.getProduct().getName(),
                        item.getQuantity()))
                .collect(Collectors.toList());
        dto.setItems(itemDtos);
        return dto;
    }
}
