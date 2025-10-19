/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.citizens.usecase;

import com.citizens.entity.dto.CitizenDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CitizenUseCase {

    CitizenDto registrar(CitizenDto citizenDto);

    CitizenDto buscarPorId(Long id);

    CitizenDto buscarPorDni(String dni);

    List<CitizenDto> listarTodos();
}
