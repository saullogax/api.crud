/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saullogax.crud.controller;
import com.saullogax.crud.exception.LocalNotFoundException;
import com.saullogax.crud.service.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saul.lopez
 */
@RestController
@RequestMapping("/api/v1/greeting")
@Slf4j
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @GetMapping("/GreetingPublic/{codigo}")
    public String login(@PathVariable Long codigo) throws LocalNotFoundException{
        return greetingService.findUser(codigo);
    }

    @GetMapping("/GreetingProtected")
    public String loginProtected(){
        return "Entró protegidamente jajaja";
    }
    
}
