package com.saullogax.crud.service;

import com.saullogax.crud.exception.LocalNotFoundException;
import com.saullogax.crud.serviceimpl.GreetingServiceImpl;

public interface GreetingService  {
    String findUser(Long codigo) throws LocalNotFoundException;
}
