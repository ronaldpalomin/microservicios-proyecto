/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.citizens.controller;

import com.citizens.entity.dto.CitizenDto;
import com.citizens.usecase.CitizenUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/citizens")
public class CitizenController {

    private final CitizenUseCase citizenUseCase;

    @PostMapping
    public CitizenDto registrar(@RequestBody CitizenDto citizenDto) {
        return citizenUseCase.registrar(citizenDto);
    }

    @GetMapping("/{id}")
    public CitizenDto buscarPorId(@PathVariable Long id) {
        return citizenUseCase.buscarPorId(id);
    }

    @GetMapping("/dni/{dni}")
    public CitizenDto buscarPorDni(@PathVariable String dni) {
        return citizenUseCase.buscarPorDni(dni);
    }

    @GetMapping
    public List<CitizenDto> listarTodos() {
        return citizenUseCase.listarTodos();
    }
}
