/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.saullogax.crud.service;

import com.saullogax.crud.dto.ClienteDto;
import com.saullogax.crud.dto.WebResponseDto;

/**
 *
 * @author saul.lopez
 */
public interface AgregarService {
    public WebResponseDto agregarCliente(ClienteDto dto);
}
