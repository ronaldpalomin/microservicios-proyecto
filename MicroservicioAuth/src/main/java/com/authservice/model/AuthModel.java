/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.model;

import com.authservice.entity.bean.Usuario;
import com.authservice.entity.dto.UsuarioDto;
import com.authservice.persistence.UsuarioRepository;
import com.authservice.usecase.AuthUseCase;
import com.authservice.util.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthModel implements AuthUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ModelMapper modelMapper;

    @Override
    public String login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return jwtUtil.generarToken(username);
    }

    @Override
    public UsuarioDto registrar(UsuarioDto usuarioDto, String rawPassword) {
        Usuario usuario = Usuario.builder()
                .username(usuarioDto.getUsername())
                .password(passwordEncoder.encode(rawPassword))
                .role(usuarioDto.getRole())
                .enabled(true)
                .build();
        Usuario saved = usuarioRepository.save(usuario);
        return modelMapper.map(saved, UsuarioDto.class);
    }
}
