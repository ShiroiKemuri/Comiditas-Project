package co.edu.uvpalmira.urss.Backend.Model.IRepository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uvpalmira.urss.Backend.Model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsuario(String usuario);

}