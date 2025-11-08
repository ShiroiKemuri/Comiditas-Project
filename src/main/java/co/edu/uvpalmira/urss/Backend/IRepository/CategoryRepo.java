package co.edu.uvpalmira.urss.Backend.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uvpalmira.urss.Backend.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
