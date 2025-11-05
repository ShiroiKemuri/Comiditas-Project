package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uvpalmira.urss.Backend.DTO.LoginRequest;
import co.edu.uvpalmira.urss.Backend.DTO.LoginResponse;
import co.edu.uvpalmira.urss.Backend.Model.Admin;
import co.edu.uvpalmira.urss.Backend.Model.IRepository.AdminRepo;
import co.edu.uvpalmira.urss.Backend.Utilities.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private AdminRepo administradorRepo;
    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse autenticar(LoginRequest request) {
        Admin admin = administradorRepo.findByUsuario(request.getUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!admin.getPassword().equals(request.getContraseña())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtUtil.generarToken(admin.getUsuario());
        return new LoginResponse(token, "Autenticación exitosa");
    }

}
