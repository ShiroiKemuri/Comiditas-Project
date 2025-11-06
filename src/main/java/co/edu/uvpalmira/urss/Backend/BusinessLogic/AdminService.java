package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import co.edu.uvpalmira.urss.Backend.Model.Admin;
import co.edu.uvpalmira.urss.Backend.Model.IRepository.AdminRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo administradorRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin crearAdministrador(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return administradorRepo.save(admin);
    }

    public Admin SearchById(Long id) {
        return administradorRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin no encontrado"));
    }

    public void eliminarAdministrador(Long id) {
        administradorRepo.deleteById(id);
    }

    public Admin actualizarAdministrador(Long id, Admin adminActualizado) {
        return administradorRepo.findById(id).map(admin -> {
            admin.setUsuario(adminActualizado.getUsuario());
            if (adminActualizado.getPassword() != null && !adminActualizado.getPassword().isEmpty()) {
                admin.setPassword(passwordEncoder.encode(adminActualizado.getPassword()));
            }
            admin.setNombre(adminActualizado.getNombre());
            return administradorRepo.save(admin);
        }).orElse(null);
    }

}
