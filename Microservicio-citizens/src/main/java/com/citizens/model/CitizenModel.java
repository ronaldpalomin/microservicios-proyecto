/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.citizens.model;

import com.citizens.entity.bean.Citizen;
import com.citizens.entity.dto.CitizenDto;
import com.citizens.persistence.CitizenRepository;
import com.citizens.usecase.CitizenUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CitizenModel implements CitizenUseCase {

    private final CitizenRepository citizenRepository;
    private final ModelMapper modelMapper;

    @Override
    public CitizenDto registrar(CitizenDto citizenDto) {
        Citizen citizen = modelMapper.map(citizenDto, Citizen.class);
        Citizen saved = citizenRepository.save(citizen);
        return modelMapper.map(saved, CitizenDto.class);
    }

    @Override
    public CitizenDto buscarPorId(Long id) {
        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ciudadano no encontrado"));
        return modelMapper.map(citizen, CitizenDto.class);
    }

    @Override
    public CitizenDto buscarPorDni(String dni) {
        Citizen citizen = citizenRepository.findByDni(dni)
                .orElseThrow(() -> new RuntimeException("Ciudadano no encontrado"));
        return modelMapper.map(citizen, CitizenDto.class);
    }

    @Override
    public List<CitizenDto> listarTodos() {
        return citizenRepository.findAll().stream()
                .map(c -> modelMapper.map(c, CitizenDto.class))
                .collect(Collectors.toList());
    }
}
