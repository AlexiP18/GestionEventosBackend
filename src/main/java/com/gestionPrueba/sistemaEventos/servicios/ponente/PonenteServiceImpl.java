package com.gestionPrueba.sistemaEventos.servicios.ponente;

import com.gestionPrueba.sistemaEventos.dto.AdDTO;
import com.gestionPrueba.sistemaEventos.entidades.Ad;
import com.gestionPrueba.sistemaEventos.entidades.User;
import com.gestionPrueba.sistemaEventos.repositorio.AdRepository;
import com.gestionPrueba.sistemaEventos.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PonenteServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdRepository adRepository;

}
