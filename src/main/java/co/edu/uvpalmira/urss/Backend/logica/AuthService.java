package co.edu.uvpalmira.urss.Backend.logica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uvpalmira.urss.Backend.DTO.LoginRequest;
import co.edu.uvpalmira.urss.Backend.DTO.LoginResponse;
import co.edu.uvpalmira.urss.Backend.modelo.Administrador;
import co.edu.uvpalmira.urss.Backend.modelo.IRepository.AdministradorRepo;
import co.edu.uvpalmira.urss.Backend.Utilities.JwtUtil;
@Service
public class AuthService {

     @Autowired
    private AdministradorRepo administradorRepo;
    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse autenticar(LoginRequest request) {
        Administrador admin = administradorRepo.findByUsuario(request.getUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!admin.getContraseña().equals(request.getContraseña())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtUtil.generarToken(admin.getUsuario());
        return new LoginResponse(token, "Autenticación exitosa");
    }

}
