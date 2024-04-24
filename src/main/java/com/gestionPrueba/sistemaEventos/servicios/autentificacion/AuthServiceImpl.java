package com.gestionPrueba.sistemaEventos.servicios.autentificacion;

import com.gestionPrueba.sistemaEventos.dto.SignupRequestDTO;
import com.gestionPrueba.sistemaEventos.dto.UserDto;
import com.gestionPrueba.sistemaEventos.entidades.User;
import com.gestionPrueba.sistemaEventos.enums.UserRole;
import com.gestionPrueba.sistemaEventos.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO){
        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword((signupRequestDTO.getPassword()));

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }

}