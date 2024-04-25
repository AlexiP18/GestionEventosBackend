package com.gestionPrueba.sistemaEventos.servicios.ponente;

import com.gestionPrueba.sistemaEventos.dto.AdDTO;
import com.gestionPrueba.sistemaEventos.dto.ReservationDTO;
import com.gestionPrueba.sistemaEventos.entidades.Ad;
import com.gestionPrueba.sistemaEventos.entidades.Reservation;
import com.gestionPrueba.sistemaEventos.entidades.User;
import com.gestionPrueba.sistemaEventos.repositorio.AdRepository;
import com.gestionPrueba.sistemaEventos.repositorio.ReservationRepository;
import com.gestionPrueba.sistemaEventos.repositorio.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PonenteServiceImplTest {

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private AdRepository mockAdRepository;

    @Mock
    private ReservationRepository mockReservationRepository;

    @InjectMocks
    private PonenteServiceImpl companyService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostAd() throws IOException {
        // Arrange
        AdDTO adDTO = new AdDTO();
        adDTO.setServiceName("Test Service");
        adDTO.setDescription("Test Description");
// Simula un MultipartFile (reemplaza null con un objeto MultipartFile válido)
        adDTO.setImg(mock(MultipartFile.class));
        adDTO.setPrice(100.0);

        when(mockUserRepository.findById(anyLong())).thenReturn(Optional.of(new User()));

        // Act
        boolean result = companyService.postAd(1L, adDTO);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testGetAllAds() {
        // Arrange
        when(mockAdRepository.findAllByUserId(anyLong())).thenReturn(new ArrayList<>());

        // Act
        List<AdDTO> adDTOList = companyService.getAllAds(1L);

        // Assert
        assertNotNull(adDTOList);
    }


    @Test
    public void testUpdateAd() throws IOException {
        // Arrange
        AdDTO adDTO = new AdDTO();
        adDTO.setServiceName("Updated Service");
        adDTO.setDescription("Updated Description");
        adDTO.setImg(null);
        adDTO.setPrice(200.0);

        when(mockAdRepository.findById(anyLong())).thenReturn(Optional.of(new Ad()));

        // Act
        boolean result = companyService.updateAd(1L, adDTO);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testDeleteAd() {
        // Arrange
        when(mockAdRepository.findById(anyLong())).thenReturn(Optional.of(new Ad()));

        // Act
        boolean result = companyService.deleteAd(1L);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testGetAllAdBookings() {
        // Arrange
        when(mockReservationRepository.findAllByPonenteId(anyLong())).thenReturn(new ArrayList<>());

        // Act
        List<ReservationDTO> reservationDTOList = companyService.getAllAdEventos(1L);

        // Assert
        assertNotNull(reservationDTOList);
    }

    @Test
    public void testChangeBookingStatus() {
        // Arrange
        when(mockReservationRepository.findById(anyLong())).thenReturn(Optional.of(new Reservation()));

        // Act
        boolean result = companyService.changeEventoStatus(1L, "Approve");

        // Assert
        assertTrue(result);
    }
}