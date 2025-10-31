package co.edu.uvpalmira.urss.Backend.dto;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdminDTO {

    private Long id;
    private String nombre;
    private String usuario;
    private String password;
}
