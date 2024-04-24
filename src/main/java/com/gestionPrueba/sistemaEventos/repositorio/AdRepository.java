package com.gestionPrueba.sistemaEventos.repositorio;

import com.gestionPrueba.sistemaEventos.entidades.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

}
