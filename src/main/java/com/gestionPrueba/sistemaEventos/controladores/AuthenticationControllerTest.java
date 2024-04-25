package com.gestionPrueba.sistemaEventos.controladores;

import com.gestionPrueba.sistemaEventos.dto.SignupRequestDTO;
import com.gestionPrueba.sistemaEventos.dto.UserDto;
import com.gestionPrueba.sistemaEventos.repositorio.UserRepository;
import com.gestionPrueba.sistemaEventos.servicios.autentificacion.AuthService;
import com.gestionPrueba.sistemaEventos.servicios.jwt.UserDetailsServiceImpl;
import com.gestionPrueba.sistemaEventos.utill.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.WriteListener;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class AuthenticationControllerTest {

    @Mock
    private AuthService mockAuthService;

    @Mock
    private AuthenticationManager mockAuthenticationManager;

    @Mock
    private UserDetailsServiceImpl mockUserDetailsService;

    @Mock
    private JwtUtil mockJwtUtil;

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private AuthenticationController authenticationController;

    @Mock
    private HttpServletResponse mockResponse;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSignupClient() {
        // Arrange
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        when(mockAuthService.presentByEmail(anyString())).thenReturn(false);
        when(mockAuthService.signupClient(any())).thenReturn(new UserDto());

        // Act
        ResponseEntity<?> responseEntity = authenticationController.signupClient(signupRequestDTO);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testSignupCompany() {
        // Arrange
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        when(mockAuthService.presentByEmail(anyString())).thenReturn(false);
        when(mockAuthService.signupPonente(any())).thenReturn(new UserDto());

        // Act
        ResponseEntity<?> responseEntity = authenticationController.signupPonente(signupRequestDTO);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}