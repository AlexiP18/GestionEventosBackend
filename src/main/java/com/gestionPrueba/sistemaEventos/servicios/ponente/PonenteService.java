package com.gestionPrueba.sistemaEventos.servicios.ponente;

import com.gestionPrueba.sistemaEventos.dto.AdDTO;
import com.gestionPrueba.sistemaEventos.dto.ReservationDTO;

import java.io.IOException;
import java.util.List;

public interface PonenteService {

    boolean postAd(Long userId, AdDTO adDTO) throws IOException;

    List<AdDTO> getAllAds(Long userId);

    AdDTO getAdById(Long adId);

    boolean updateAd(Long adId, AdDTO adDTO) throws IOException;

    boolean deleteAd(Long adId);

    List<ReservationDTO> getAllAdEventos(Long ponenteId);

    boolean changeEventoStatus(Long eventoId, String status);
}
