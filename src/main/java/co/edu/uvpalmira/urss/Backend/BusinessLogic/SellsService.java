package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uvpalmira.urss.Backend.IRepository.SellsRepo;
import co.edu.uvpalmira.urss.Backend.Model.Sells;
import java.util.List;

@Service
public class SellsService {

    @Autowired
    private SellsRepo sellsRepo;

    public Sells createSells(Sells sell) {
        return sellsRepo.save(sell);
    }

    public Sells getSellsById(Long id) {
        return sellsRepo.findById(id).orElse(null);
    }

    public Sells updateSells(Long id, Sells updatedSell) {
        return sellsRepo.findById(id).map(sell -> {
            sell.setId_Sell(updatedSell.getId_Sell());
            sell.setDate(updatedSell.getDate());
            sell.setTotalAmount(updatedSell.getTotalAmount());
            sell.setProducts(updatedSell.getProducts());
            sell.setQuantity(updatedSell.getQuantity());
            return sellsRepo.save(sell);
        }).orElse(null);
    }

    public List<Sells> getAllSells() {
        return sellsRepo.findAll();
    }
}
