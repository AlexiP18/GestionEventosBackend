package com.gestionPrueba.sistemaEventos.servicios.cliente;

import com.gestionPrueba.sistemaEventos.dto.AdDTO;
import com.gestionPrueba.sistemaEventos.dto.AdDetailsForClientDTO;
import com.gestionPrueba.sistemaEventos.dto.ReservationDTO;
import com.gestionPrueba.sistemaEventos.dto.ReviewDTO;
import com.gestionPrueba.sistemaEventos.entidades.Ad;
import com.gestionPrueba.sistemaEventos.entidades.Reservation;
import com.gestionPrueba.sistemaEventos.entidades.User;
import com.gestionPrueba.sistemaEventos.repositorio.AdRepository;
import com.gestionPrueba.sistemaEventos.repositorio.ReservationRepository;
import com.gestionPrueba.sistemaEventos.repositorio.ReviewRepository;
import com.gestionPrueba.sistemaEventos.repositorio.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ClientServiceImplTest {

    @Mock
    private AdRepository mockAdRepository;

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private ReservationRepository mockReservationRepository;

    @Mock
    private ReviewRepository mockReviewRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAds() {
        // Arrange
        when(mockAdRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<AdDTO> adDTOList = clientService.getAllAds();

        // Assert
        assertNotNull(adDTOList);
    }

    @Test
    public void testSearchAdByName() {
        // Arrange
        when(mockAdRepository.findAllByServiceNameContaining(anyString())).thenReturn(new ArrayList<>());

        // Act
        List<AdDTO> adDTOList = clientService.searchAdByName("Test");

        // Assert
        assertNotNull(adDTOList);
    }

    @Test
    public void testBookService() {
        // Arrange
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setEventoDate(new Date());
        reservationDTO.setUserId(1L);
        reservationDTO.setAdId(1L);

        when(mockAdRepository.findById(anyLong())).thenReturn(Optional.of(new Ad()));
        when(mockUserRepository.findById(anyLong())).thenReturn(Optional.of(new User()));

        // Act
        boolean result = clientService.eventoService(reservationDTO);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testGetAdDetailsByAdId() {
        // Arrange
        Ad ad = new Ad();
        User user = new User();
        user.setName("TestUser");
        ad.setUser(user);

        when(mockAdRepository.findById(anyLong())).thenReturn(Optional.of(ad));
        when(mockReviewRepository.findAllByAdId(anyLong())).thenReturn(new ArrayList<>());

        // Act
        AdDetailsForClientDTO adDetailsForClientDTO = clientService.getAdDetailsByAdId(1L);

        // Assert
        assertNotNull(adDetailsForClientDTO);
    }


    @Test
    public void testGetAllBookingsByUserId() {
        // Arrange
        when(mockReservationRepository.findAllByUserId(anyLong())).thenReturn(new ArrayList<>());

        // Act
        List<ReservationDTO> reservationDTOList = clientService.getAllEventosByUserId(1L);

        // Assert
        assertNotNull(reservationDTOList);
    }

    @Test
    public void testGiveReview() {
        // Arrange
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setUserId(1L);
        reviewDTO.setEventoId(1L);
        reviewDTO.setReview("Test Review");
        reviewDTO.setRating(5L);

        when(mockUserRepository.findById(anyLong())).thenReturn(Optional.of(new User()));
        when(mockReservationRepository.findById(anyLong())).thenReturn(Optional.of(new Reservation()));

        // Act
        boolean result = clientService.giveReview(reviewDTO);

        // Assert
        assertTrue(result);
    }
}
