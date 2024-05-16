package com.saullogax.crud.service;

import com.saullogax.crud.models.AuthResponse;
import com.saullogax.crud.models.AuthenticationRequest;
import com.saullogax.crud.models.RegisterRequest;

public interface AuthService {
    AuthResponse register (RegisterRequest request);
    AuthResponse authenticate (AuthenticationRequest request);

}
