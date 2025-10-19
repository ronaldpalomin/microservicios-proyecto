/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.record.usecase;

import com.record.entity.bean.RecordEntity;
import com.record.entity.dto.RecordEntityDto;
import reactor.core.publisher.Mono;

/**
 *
 * @author ronal
 */
public interface RecordUseCase {
    
    Mono<RecordEntity> crearRecord(Long citizenId, RecordEntity record);

    Mono<RecordEntity> buscarRecord(Long id);
}
