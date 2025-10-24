package co.edu.uvpalmira.urss.Backend.modelo.IRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uvpalmira.urss.Backend.modelo.Administrador;

public interface AdministradorRepo  extends JpaRepository<Administrador, Long>{

    Optional<Administrador> findByUsuario(String usuario);

}