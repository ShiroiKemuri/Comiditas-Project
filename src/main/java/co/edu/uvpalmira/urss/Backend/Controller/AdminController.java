package co.edu.uvpalmira.urss.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uvpalmira.urss.Backend.Model.Admin;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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

    @PostMapping("/getAdmin")
    public Admin getAdminById(@RequestParam Long id) {
        return adminService.SearchById(id);
    }

    @PostMapping("/deleteAdmin")
    public void deleteAdmin(@RequestParam Long id) {
        adminService.eliminarAdministrador(id);
    }

    @PostMapping("/updateAdmin")
    public Admin updateAdmin(@RequestParam Long id, @RequestBody Admin adminActualizado) {
        return adminService.actualizarAdministrador(id, adminActualizado);
    }

}
