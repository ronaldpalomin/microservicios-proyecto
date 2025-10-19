/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.record.controller;

import com.record.entity.bean.RecordEntity;
import com.record.entity.dto.RecordEntityDto;
import com.record.usecase.RecordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordUseCase recordUseCase;

    // Crear un record para un ciudadano específico
    @PostMapping("/{citizenId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RecordEntity> crearRecord(@PathVariable Long citizenId, @RequestBody RecordEntity record) {
        return recordUseCase.crearRecord(citizenId, record);
    }

    // Buscar un record por su id
    @GetMapping("/{id}")
    public Mono<RecordEntity> buscarRecord(@PathVariable Long id) {
        return recordUseCase.buscarRecord(id);
    }
}
