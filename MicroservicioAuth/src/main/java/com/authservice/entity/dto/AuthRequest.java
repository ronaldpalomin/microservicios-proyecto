/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.authservice.entity.dto;

import lombok.Data;


@Data
public class AuthRequest {
    private String username;
    private String password;
}