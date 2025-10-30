package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uvpalmira.urss.Backend.Model.Admin;
import co.edu.uvpalmira.urss.Backend.Model.IRepository.AdminRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo administradorRepo;

    public Admin crearAdministrador(Admin admin) {
        return administradorRepo.save(admin);
    }

    public Admin SearchById(Long id) {
        return administradorRepo.findById(id).orElse(null);
    }

    public void eliminarAdministrador(Long id) {
        administradorRepo.deleteById(id);
    }

    public Admin actualizarAdministrador(Long id, Admin adminActualizado) {
        return administradorRepo.findById(id).map(admin -> {
            admin.setUsuario(adminActualizado.getUsuario());
            admin.setPassword(adminActualizado.getPassword());
            admin.setNombre(adminActualizado.getNombre());
            return administradorRepo.save(admin);
        }).orElse(null);
    }

}
