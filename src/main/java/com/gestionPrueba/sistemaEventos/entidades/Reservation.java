package com.gestionPrueba.sistemaEventos.entidades;

import com.gestionPrueba.sistemaEventos.dto.ReservationDTO;
import com.gestionPrueba.sistemaEventos.enums.ReservationStatus;
import com.gestionPrueba.sistemaEventos.enums.ReviewStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ReservationStatus reservationStatus;

    private ReviewStatus reviewStatus;

    private Date eventoDate;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ponente_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User ponente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ad_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ad ad;

    public ReservationDTO getReservationDto(){
        ReservationDTO dto = new ReservationDTO();

        dto.setId(id);
        dto.setServiceName(ad.getServiceName());
        dto.setEventoDate(eventoDate);
        dto.setReservationStatus(reservationStatus);
        dto.setReviewStatus(reviewStatus);

        dto.setAdId(ad.getId());
        dto.setPonenteId(ponente.getId());
        dto.setUserName(user.getName());

        return dto;
    }
}
