package co.edu.uvpalmira.urss.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uvpalmira.urss.Backend.BusinessLogic.SellsService;
import co.edu.uvpalmira.urss.Backend.Model.Sells;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sells")
public class SellsController {

    @Autowired
    private SellsService sellsService;

    @PostMapping("/createSell")
    public Sells createSell(@RequestBody Sells sell) {
        return sellsService.createSells(sell);
    }

    @GetMapping("/getSellById/{id}")
    public Sells getSellById(@PathVariable("id") Long id) {
        return sellsService.getSellsById(id);
    }

    @PutMapping("/updateSell/{id}")
    public Sells updateSell(@PathVariable("id") Long id, @RequestBody Sells updatedSell) {
        return sellsService.updateSells(id, updatedSell);
    }

    @GetMapping("/getAllSells")
    public java.util.List<Sells> getAllSells() {
        return sellsService.getAllSells();
    }

}
