package co.edu.uvpalmira.urss.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uvpalmira.urss.Backend.Model.Admin;
import org.springframework.web.bind.annotation.RequestBody;
import co.edu.uvpalmira.urss.Backend.BusinessLogic.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/createAdmin")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.crearAdministrador(admin);
    }

    @GetMapping("/getAdminById/{id}")
    public Admin getAdminById(@PathVariable("id") Long id) {
        return adminService.SearchById(id);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.eliminarAdministrador(id);
    }

    @PutMapping("/updateAdmin/{id}")
    public Admin updateAdmin(@PathVariable("id") Long id, @RequestBody Admin adminActualizado) {
        return adminService.actualizarAdministrador(id, adminActualizado);
    }

}
