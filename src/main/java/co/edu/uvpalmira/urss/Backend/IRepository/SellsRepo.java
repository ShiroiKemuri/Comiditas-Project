package co.edu.uvpalmira.urss.Backend.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uvpalmira.urss.Backend.Model.Sale;

public interface SellsRepo extends JpaRepository<Sale, Long> {

}
