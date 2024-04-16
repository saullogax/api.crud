/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saullogax.crud.controller;

import com.saullogax.com.constants.ConstantsMSG;
import com.saullogax.crud.dto.ClienteDto;
import com.saullogax.crud.dto.WebResponse;
import com.saullogax.crud.service.AgregarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saullogax.crud.dto.WebResponseDto;
import com.saullogax.crud.exception.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author saul.lopez
 */
@RestController
@RequestMapping("/agregar")
@Slf4j
public class AgregarController {

    @Autowired
    AgregarService agregarS;

    @PutMapping("/agregarUsuario")
    public ResponseEntity<WebResponseDto> agregarUsuario(@RequestBody
           ClienteDto dto) {
        try {     
            if (!"".equals(dto.getNomCliente()) && !"".equals(dto.getDomicilio()) && !"".equals(dto.getNumCliente())) {
                return ResponseEntity.ok(agregarS.agregarCliente(dto));
            } else {
                ResponseException re = new ResponseException(ConstantsMSG.MSG_BAD_PARAMETERS);
                re.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                re.setResponse(new WebResponse((short) 5, ConstantsMSG.MSG_BAD_PARAMETERS, null));
                throw re;
            }
        } catch (ResponseException ex) {
            ResponseException re = new ResponseException(ConstantsMSG.MSG_BAD_PARAMETERS);
            re.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            re.setResponse(new WebResponse((short) 3, ConstantsMSG.MSG_ERROR_SERVICIO, ex));
            throw re;

        }
    }
}
