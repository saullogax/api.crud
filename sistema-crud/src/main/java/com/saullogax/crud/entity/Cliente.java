package com.saullogax.crud.entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="cat_clientes")
@Data
public class Cliente {
    
    @Id
    @Column(name = "num_cliente")
    private Long numCliente;
    
    @Column(name = "nom_cliente")
    private String nom_cliente;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    
    @Column(name = "domicilio")
    private String domicilio;
    
    @Column(name = "num_interior")
    private int num_interior;
    
    @Column(name = "fecha_registro")
    private Date fecha_registro;
    
    @Column(name = "fecha_modificacion")
    private Date fecha_modificacion;
    
    @Column(name = "estatus")
    private short estatus;

    public Long getNum_cliente() {
        return numCliente;
    }

    public void setNum_cliente(Long num_cliente) {
        this.numCliente = num_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getNum_interior() {
        return num_interior;
    }

    public void setNum_interior(int num_interior) {
        this.num_interior = num_interior;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public short getEstatus() {
        return estatus;
    }

    public void setEstatus(short estatus) {
        this.estatus = estatus;
    }

    public Cliente() {
        super();
    }

}
