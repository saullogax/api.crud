package com.saullogax.crud.repository;

import com.saullogax.crud.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findAllByNumCliente(int num_cliente);
    
//    public Cliente save(ClienteDto dto);

//    public void save(ClienteDto dto);
}
