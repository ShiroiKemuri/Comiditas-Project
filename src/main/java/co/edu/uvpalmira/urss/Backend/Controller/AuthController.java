package co.edu.uvpalmira.urss.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uvpalmira.urss.Backend.BusinessLogic.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Auth Controller", description = "Manejo de autenticación de administradores")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Operation(summary = "Iniciar sesión", description = "Permite a un administrador iniciar sesión y obtener un token JWT")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody co.edu.uvpalmira.urss.Backend.DTO.LoginRequest request) {
        try {
            co.edu.uvpalmira.urss.Backend.DTO.LoginResponse response = authService.autenticar(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

}
