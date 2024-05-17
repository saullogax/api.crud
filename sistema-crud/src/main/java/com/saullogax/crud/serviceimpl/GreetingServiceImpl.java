package com.saullogax.crud.serviceimpl;

import com.saullogax.crud.entity.User;
import com.saullogax.crud.exception.LocalNotFoundException;
import com.saullogax.crud.repository.UserRepository;
import com.saullogax.crud.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GreetingServiceImpl implements GreetingService {
    private final UserRepository userRepository;

    public String findUser(Long codigo) throws LocalNotFoundException{
        Optional<User> id = userRepository.findById(codigo);
        if(!id.isPresent()){
            throw new LocalNotFoundException("Code not found");
        }
        return "Hola " + id.get().getNombre() + ", bienvenido.";
    }

}
