package co.edu.uvpalmira.urss.Backend.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uvpalmira.urss.Backend.BusinessLogic.SellsService;
import co.edu.uvpalmira.urss.Backend.DTO.CreateSaleRequestDto;
import co.edu.uvpalmira.urss.Backend.Model.Sale;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sells")
public class SellsController {

    @Autowired
    private SellsService sellsService;

    @PostMapping("/createSell")
    public ResponseEntity<Sale> createSell(@RequestBody CreateSaleRequestDto saleRequest) {
        Sale newSale = sellsService.createSale(saleRequest);
        return ResponseEntity.ok(newSale);
    }

    @GetMapping("/getSaleById/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        Sale sale = sellsService.getSaleById(id);
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/getAllSales")
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = sellsService.getAllSales();
        return ResponseEntity.ok(sales);
    }

}
