/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.record.entity.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import java.time.LocalDateTime;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("record")
public class RecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    
    @Column("type")
    private RecordType  type; // NACIMIENTO, MATRIMONIO, SOLTERIA, DEFUNCION, OTRO
    private LocalDate date_of_event;
    private String place;
    private String data_json;
    
    @Column("status")
    private RecordStatus status;
    
    private LocalDate issued_at;
    private String issued_by;
    private Long citizen_id; 
}