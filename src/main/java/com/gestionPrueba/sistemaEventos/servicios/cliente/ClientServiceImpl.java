package com.gestionPrueba.sistemaEventos.servicios.cliente;

import com.gestionPrueba.sistemaEventos.dto.AdDTO;
import com.gestionPrueba.sistemaEventos.dto.AdDetailsForClientDTO;
import com.gestionPrueba.sistemaEventos.dto.ReservationDTO;
import com.gestionPrueba.sistemaEventos.entidades.Ad;
import com.gestionPrueba.sistemaEventos.entidades.Reservation;
import com.gestionPrueba.sistemaEventos.entidades.User;
import com.gestionPrueba.sistemaEventos.enums.ReservationStatus;
import com.gestionPrueba.sistemaEventos.enums.ReviewStatus;
import com.gestionPrueba.sistemaEventos.repositorio.AdRepository;
import com.gestionPrueba.sistemaEventos.repositorio.ReservationRepository;
import com.gestionPrueba.sistemaEventos.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<AdDTO> getAllAds(){
        return adRepository.findAll().stream().map(Ad::getAdDto).collect(Collectors.toList());
    }

    public List<AdDTO> searchAdByName(String name){
        return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDto).collect(Collectors.toList());
    }

    public boolean eventoService(ReservationDTO reservationDTO){
        Optional<Ad> optionalAd = adRepository.findById(reservationDTO.getAdId());
        Optional<User> optionalUser = userRepository.findById(reservationDTO.getUserId());

        if(optionalAd.isPresent() && optionalUser.isPresent()){
            Reservation reservation = new Reservation();

            reservation.setEventoDate(reservationDTO.getEventoDate());
            reservation.setReservationStatus(ReservationStatus.PENDING);
            reservation.setUser(optionalUser.get());

            reservation.setAd(optionalAd.get());
            reservation.setPonente(optionalAd.get().getUser());
            reservation.setReviewStatus(ReviewStatus.FALSE);

            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }

    public AdDetailsForClientDTO getAdDetailsByAdId(Long adId){
        Optional<Ad> optionalAd = adRepository.findById(adId);
        AdDetailsForClientDTO adDetailsForClientDTO = new AdDetailsForClientDTO();
        if(optionalAd.isPresent()){
            adDetailsForClientDTO.setAdDTO(optionalAd.get().getAdDto());


        }
        return adDetailsForClientDTO;
    }
}
