package com.gestionPrueba.sistemaEventos.dto;

import com.gestionPrueba.sistemaEventos.enums.ReservationStatus;
import com.gestionPrueba.sistemaEventos.enums.ReviewStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDTO {

    private Long id;

    private Date eventoDate;

    private String serviceName;

    private ReservationStatus reservationStatus;

    private ReviewStatus reviewStatus;

    private Long userId;

    private String userName;

    private Long ponenteId;

    private Long adId;

}
