package co.edu.uvpalmira.urss.Backend.BusinessLogic;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uvpalmira.urss.Backend.DTO.LoginRequest;
import co.edu.uvpalmira.urss.Backend.DTO.LoginResponse;
import co.edu.uvpalmira.urss.Backend.IRepository.AdminRepo;
import co.edu.uvpalmira.urss.Backend.Model.Admin;
import co.edu.uvpalmira.urss.Backend.Utilities.JwtUtil;
import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    private AdminRepo administradorRepo;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse autenticar(LoginRequest request) {
        String username = request.getUser();

        Admin admin = administradorRepo.findByUsuario(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (admin.getAccountLockedUntil() != null && admin.getAccountLockedUntil().isAfter(LocalDateTime.now())) {
            throw new RuntimeException("La cuenta está bloqueada temporalmente. Inténtelo más tarde.");
        }

        if (passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            // Si el login es exitoso, reseteamos los contadores
            admin.setFailedLoginAttempts(0);
            admin.setAccountLockedUntil(null);
            administradorRepo.save(admin);

            String token = jwtUtil.generarToken(admin.getUsuario());
            return new LoginResponse(token, "Autenticación exitosa");
        }

        // Si la contraseña es incorrecta, manejamos la lógica de intentos fallidos
        admin.setFailedLoginAttempts(admin.getFailedLoginAttempts() + 1);
        if (admin.getFailedLoginAttempts() >= 3) {
            admin.setAccountLockedUntil(LocalDateTime.now().plusMinutes(20));
            administradorRepo.save(admin);
            throw new RuntimeException("Contraseña incorrecta. La cuenta ha sido bloqueada por 20 minutos.");
        }
        administradorRepo.save(admin);
        throw new RuntimeException("Contraseña incorrecta.");
    }

}
