/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saullogax.crud.controller;

import com.saullogax.crud.dto.WebResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saul.lopez
 */
@RestController
@RequestMapping("/health")
@Slf4j
public class LivenessController {
    
    @GetMapping("/liveness")
    public ResponseEntity<WebResponseDto> getLiveness() {
        WebResponseDto wr = new WebResponseDto();
        wr.setMessage("Ready");
        wr.setHttpStatus(HttpStatus.OK);
        return ResponseEntity.ok(wr);
    }

}
