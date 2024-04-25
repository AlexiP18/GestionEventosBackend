package com.gestionPrueba.sistemaEventos.servicios.cliente;

import com.gestionPrueba.sistemaEventos.dto.AdDTO;
import com.gestionPrueba.sistemaEventos.dto.AdDetailsForClientDTO;
import com.gestionPrueba.sistemaEventos.dto.ReservationDTO;

import java.util.List;

public interface ClientService {

    List<AdDTO> getAllAds();

    List<AdDTO> searchAdByName(String name);

    boolean eventoService(ReservationDTO reservationDTO);

    AdDetailsForClientDTO getAdDetailsByAdId(Long adId);
}
