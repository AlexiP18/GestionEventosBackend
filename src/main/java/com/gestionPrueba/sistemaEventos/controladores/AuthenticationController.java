package com.gestionPrueba.sistemaEventos.controladores;

import com.gestionPrueba.sistemaEventos.dto.SignupRequestDTO;
import com.gestionPrueba.sistemaEventos.dto.UserDto;
import com.gestionPrueba.sistemaEventos.servicios.autentificacion.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/client/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO){

        if(authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("Este Cliente ya existe con este email!", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto createdUser = authService.signupClient(signupRequestDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/ponente/sign-up")
    public ResponseEntity<?> signupPonente(@RequestBody SignupRequestDTO signupRequestDTO){

        if(authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("Este Ponente ya existe con este Email!", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto createdUser = authService.signupPonente(signupRequestDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}
