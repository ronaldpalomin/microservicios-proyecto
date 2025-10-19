
package com.authservice.usecase;


import com.authservice.entity.dto.UsuarioDto;
import org.springframework.stereotype.Component;

@Component
public interface AuthUseCase {
    String login(String username, String password);
    UsuarioDto registrar(UsuarioDto usuarioDto, String rawPassword);
}
