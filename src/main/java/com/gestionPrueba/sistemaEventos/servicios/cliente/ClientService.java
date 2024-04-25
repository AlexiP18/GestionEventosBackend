package com.gestionPrueba.sistemaEventos.servicios.cliente;

import com.gestionPrueba.sistemaEventos.dto.AdDTO;
import com.gestionPrueba.sistemaEventos.dto.AdDetailsForClientDTO;
import com.gestionPrueba.sistemaEventos.dto.ReservationDTO;
import com.gestionPrueba.sistemaEventos.dto.ReviewDTO;

import java.util.List;

public interface ClientService {

    List<AdDTO> getAllAds();

    List<AdDTO> searchAdByName(String name);

    boolean eventoService(ReservationDTO reservationDTO);

    AdDetailsForClientDTO getAdDetailsByAdId(Long adId);

    List<ReservationDTO> getAllEventosByUserId(Long userId);

    Boolean giveReview(ReviewDTO reviewDTO);
}
