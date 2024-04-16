package com.saullogax.crud.dto;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ClienteDto {
    private Long numCliente;
    private String nomCliente;
    private String telCliente;
    private Date fecNacimiento;
    private String domicilio;
    private int numInteriorCasa;
    private Date fechaRegistro;
    private Date fechaModificacion;
    private short status;

    public ClienteDto(Long numCliente, String nomCliente, String telCliente, Date fecNacimiento, String domicilio, int numInteriorCasa, Date fechaRegistro, Date fechaModificacion, short status) {
        this.numCliente = numCliente;
        this.nomCliente = nomCliente;
        this.telCliente = telCliente;
        this.fecNacimiento = fecNacimiento;
        this.domicilio = domicilio;
        this.numInteriorCasa = numInteriorCasa;
        this.fechaRegistro = fechaRegistro;
        this.fechaModificacion = fechaModificacion;
        this.status = status;
    }
}
