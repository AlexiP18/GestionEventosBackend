package com.gestionPrueba.sistemaEventos.repositorio;

import com.gestionPrueba.sistemaEventos.entidades.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByPonenteId(Long ponenteId);

    List<Reservation> findAllByUserId(Long userId);
}
