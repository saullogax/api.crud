package com.saullogax.crud.controller;

import com.saullogax.com.constants.ConstantsMSG;
import com.saullogax.crud.dto.WebResponse;
import com.saullogax.crud.dto.WebResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.saullogax.crud.service.BusquedaService;
import com.saullogax.crud.entity.Cliente;
import com.saullogax.crud.exception.ResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/search")
@Slf4j
public class BusquedaController {
    
    @Autowired
    BusquedaService busquedaS;

    @GetMapping("/searchUser/{user}")
    public ResponseEntity<WebResponseDto> obtenerUsuario(
            @PathVariable("user") int numCliente) {
        try {
            if (numCliente > 0) {
                return ResponseEntity.ok(busquedaS.busquedaCliente(numCliente));
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
