package com.gestionPrueba.sistemaEventos.servicios.ponente;

import com.gestionPrueba.sistemaEventos.dto.AdDTO;
import com.gestionPrueba.sistemaEventos.dto.ReservationDTO;
import com.gestionPrueba.sistemaEventos.entidades.Ad;
import com.gestionPrueba.sistemaEventos.entidades.Reservation;
import com.gestionPrueba.sistemaEventos.entidades.User;
import com.gestionPrueba.sistemaEventos.enums.ReservationStatus;
import com.gestionPrueba.sistemaEventos.repositorio.AdRepository;
import com.gestionPrueba.sistemaEventos.repositorio.ReservationRepository;
import com.gestionPrueba.sistemaEventos.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PonenteServiceImpl implements PonenteService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public boolean postAd(Long userId, AdDTO adDTO) throws IOException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            Ad ad = new Ad();
            ad.setServiceName(adDTO.getServiceName());
            ad.setDescription(adDTO.getDescription());
            ad.setImg(adDTO.getImg().getBytes());
            ad.setPrice(adDTO.getPrice());
            ad.setUser(optionalUser.get());

            adRepository.save(ad);
            return true;
        }
        return false;
    }

    public List<AdDTO> getAllAds(Long userId){
        return adRepository.findAllByUserId(userId).stream().map(Ad::getAdDto).collect(Collectors.toList());
    }

    public AdDTO getAdById(Long adId){
        Optional<Ad> optionalAd = adRepository.findById(adId);
        if(optionalAd.isPresent()){
            return optionalAd.get().getAdDto();
        }
        return null;
    }

    public boolean updateAd(Long adId, AdDTO adDTO) throws IOException {
        Optional<Ad> optionalAd = adRepository.findById(adId);
        if(optionalAd.isPresent()){
            Ad ad = optionalAd.get();

            ad.setServiceName(adDTO.getServiceName());
            ad.setDescription(adDTO.getDescription());
            ad.setPrice(adDTO.getPrice());

            if(adDTO.getImg() != null){
                ad.setImg(adDTO.getImg().getBytes());
            }

            adRepository.save(ad);
            return true;
        } else{
            return false;
        }
    }

    public boolean deleteAd(Long adId){
        Optional<Ad> optionalAd = adRepository.findById(adId);
        if(optionalAd.isPresent()){
            adRepository.delete(optionalAd.get());
            return true;
        }
        return false;
    }

    public List<ReservationDTO> getAllAdEventos(Long ponenteId){
        return reservationRepository.findAllByPonenteId(ponenteId)
                .stream().map(Reservation::getReservationDto).collect(Collectors.toList());
    }

    public boolean changeEventoStatus(Long eventoId, String status){
        Optional<Reservation> optionalReservation = reservationRepository.findById(eventoId);
        if(optionalReservation.isPresent()){
            Reservation existingReservation = optionalReservation.get();
            if(Objects.equals(status,"Approve")){
                existingReservation.setReservationStatus(ReservationStatus.APPROVED);
            }else{
                existingReservation.setReservationStatus(ReservationStatus.REJECTED);
            }

            reservationRepository.save(existingReservation);
            return true;
        }
        return false;
    }
}
