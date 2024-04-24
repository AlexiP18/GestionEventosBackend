package com.gestionPrueba.sistemaEventos.servicios.autentificacion;

import com.gestionPrueba.sistemaEventos.dto.SignupRequestDTO;
import com.gestionPrueba.sistemaEventos.dto.UserDto;

public interface AuthService {
    UserDto signupClient(SignupRequestDTO signupRequestDTO);

    Boolean presentByEmail(String email);

    UserDto signupPonente(SignupRequestDTO signupRequestDTO);
}
