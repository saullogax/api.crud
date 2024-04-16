/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saullogax.crud.serviceimpl;

import com.saullogax.com.constants.ConstantsMSG;
import com.saullogax.crud.dto.ClienteDto;
import com.saullogax.crud.dto.WebResponseDto;
import com.saullogax.crud.entity.Cliente;
import com.saullogax.crud.repository.ClienteRepository;
import com.saullogax.crud.service.AgregarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author saul.lopez
 */
@Service
public class AgregarServiceImpl implements AgregarService{
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public WebResponseDto agregarCliente(ClienteDto dto) {
        Cliente saveCliente = new Cliente();
        WebResponseDto wr = new WebResponseDto();       
        if (clienteRepository.existsById(dto.getNumCliente())) {
            wr.setType(0);
            wr.setHttpStatus(HttpStatus.OK);
            wr.setMessage(ConstantsMSG.MSG_CLIENTE_EXISTENTE);
            return wr;           
        } else {
            saveCliente.setNumCliente(dto.getNumCliente());
            saveCliente.setNom_cliente(dto.getNomCliente());
            saveCliente.setTelefono(dto.getTelCliente());
            saveCliente.setFecha_nacimiento(dto.getFecNacimiento());
            saveCliente.setDomicilio(dto.getDomicilio());
            saveCliente.setNum_interior(dto.getNumInteriorCasa());
            saveCliente.setFecha_registro(dto.getFechaRegistro());
            saveCliente.setFecha_modificacion(dto.getFechaModificacion());
            saveCliente.setEstatus(dto.getStatus());
            clienteRepository.save(saveCliente);
            wr.setData("Cliente agregado con éxito.");
            wr.setType(0);
            wr.setHttpStatus(HttpStatus.OK);
            return wr;

        }
    }
    
}
