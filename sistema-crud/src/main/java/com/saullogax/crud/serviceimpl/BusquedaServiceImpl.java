package com.saullogax.crud.serviceimpl;

import com.saullogax.com.constants.ConstantsMSG;
import com.saullogax.crud.dto.WebResponse;
import com.saullogax.crud.dto.WebResponseDto;
import com.saullogax.crud.entity.Cliente;
import com.saullogax.crud.exception.ResponseException;
import com.saullogax.crud.repository.ClienteRepository;
import com.saullogax.crud.service.BusquedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BusquedaServiceImpl implements BusquedaService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public WebResponseDto busquedaCliente(int numCliente) {
        Cliente findCliente = new Cliente();
        WebResponseDto wr = new WebResponseDto();
        ResponseException re = new ResponseException();
        try {
            findCliente = clienteRepository.findAllByNumCliente(numCliente);
            if (findCliente != null) {
                wr.setData(findCliente);
                wr.setType(0);
                wr.setHttpStatus(HttpStatus.OK);
                return wr;
            } else {                           
                wr.setType(5);
                wr.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
                wr.setMessage(ConstantsMSG.MSG_ERROR_BUSQUEDA);
                return wr;

            }
        } catch (ResponseException ex) {
            re.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            re.setResponse(new WebResponse((short) 3, ConstantsMSG.MSG_ERROR_SERVICIO, ex));
            throw re;
        }
    }
}
