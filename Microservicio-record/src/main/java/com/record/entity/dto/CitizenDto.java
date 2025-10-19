/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.record.entity.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitizenDto implements Serializable {

	private static final long serialVersionUID = 1L;
        
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fecha_Nacimiento;
    private String sexo;
    private String direccion;
    private String email;
    private String telefono;
}
