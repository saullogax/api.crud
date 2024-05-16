/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saullogax.crud.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saul.lopez
 */
@RestController
@RequestMapping("/v1/greeting")
@Slf4j
public class GreetingController {

    @GetMapping("/loginPublic")
    public String login(){
        return "Entró";
    }

    @GetMapping("/loginProtected")
    public String loginProtected(){
        return "Entró protegidamente jajaja";
    }
    
}
