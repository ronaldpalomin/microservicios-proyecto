/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.record.model;

import com.record.entity.bean.RecordEntity;
import com.record.entity.bean.RecordStatus;
import com.record.entity.bean.RecordType;
import com.record.entity.dto.CitizenDto;
import com.record.entity.dto.RecordEntityDto;
import com.record.persistence.RecordRepository;
import com.record.usecase.RecordUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@Service
public class RecordModel implements RecordUseCase {

    private final RecordRepository recordRepository;
    private final WebClient webClient;

    

    @Override
    public Mono<RecordEntity> buscarRecord(Long id) {
        return recordRepository.findById(id);
    }

 

    @Override
    public Mono<RecordEntity> crearRecord(Long citizenId, RecordEntity record) {
        return webClient.get()
                .uri("http://MICROSERVICIO-CITIZENS/citizens/{id}", citizenId)
                .retrieve()
                .bodyToMono(CitizenDto.class)
                .flatMap(citizenDto -> {
                    record.setCitizen_id(citizenId);
                    record.setStatus(RecordStatus.PENDIENTE);
                    return recordRepository.save(record);
                });
    }

  
}
