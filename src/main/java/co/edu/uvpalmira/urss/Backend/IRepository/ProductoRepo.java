package co.edu.uvpalmira.urss.Backend.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uvpalmira.urss.Backend.Model.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Long> {

}