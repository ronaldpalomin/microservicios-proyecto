/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.controller;


import com.authservice.entity.dto.AuthRequest;
import com.authservice.entity.dto.UsuarioDto;
import com.authservice.usecase.AuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthUseCase authUseCase;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return authUseCase.login(request.getUsername(), request.getPassword());
    }

    @PostMapping("/register/{password}")
    public UsuarioDto registrar(@RequestBody UsuarioDto usuarioDto, @PathVariable String password) {
        return authUseCase.registrar(usuarioDto, password);
    }
}