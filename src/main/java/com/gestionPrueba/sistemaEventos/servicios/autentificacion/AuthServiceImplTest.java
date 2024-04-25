package com.gestionPrueba.sistemaEventos.servicios.autentificacion;

import static org.junit.Assert.*;

import com.gestionPrueba.sistemaEventos.dto.SignupRequestDTO;
import com.gestionPrueba.sistemaEventos.dto.UserDto;
import com.gestionPrueba.sistemaEventos.entidades.User;
import com.gestionPrueba.sistemaEventos.repositorio.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class AuthServiceImplTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSignupClient() {
        // Arrange
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        signupRequestDTO.setName("Test");
        signupRequestDTO.setLastname("User");
        signupRequestDTO.setEmail("test@example.com");
        signupRequestDTO.setPhone("123456789");
        signupRequestDTO.setPassword("test123");

        when(mockUserRepository.save(any())).thenReturn(new User());

        // Act
        UserDto userDto = authService.signupClient(signupRequestDTO);

        // Assert
        assertNotNull(userDto);
    }

    @Test
    public void testPresentByEmail() {
        // Arrange
        when(mockUserRepository.findFirstByEmail(anyString())).thenReturn(null);

        // Act
        boolean result = authService.presentByEmail("test@example.com");

        // Assert
        assertFalse(result);
    }

    @Test
    public void testSignupPonente() {
        // Arrange
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        signupRequestDTO.setName("Test");
        signupRequestDTO.setEmail("test@example.com");
        signupRequestDTO.setPhone("123456789");
        signupRequestDTO.setPassword("test123");

        when(mockUserRepository.save(any())).thenReturn(new User());

        // Act
        UserDto userDto = authService.signupPonente(signupRequestDTO);

        // Assert
        assertNotNull(userDto);
    }
}