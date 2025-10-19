/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.record.entity.dto;

import com.record.entity.bean.RecordStatus;
import com.record.entity.bean.RecordType;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecordEntityDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private RecordType type;          // NACIMIENTO, MATRIMONIO, SOLTERIA, DEFUNCION, OTRO
    private LocalDate date_of_event;
    private String place;
    private String data_json;
    private RecordStatus status;      // PENDIENTE, COMPLETADO, etc.
    private LocalDate issued_at;
    private String issued_by;
}