package com.gestionPrueba.sistemaEventos.entidades;

import com.gestionPrueba.sistemaEventos.enums.UserRole;
import com.gestionPrueba.sistemaEventos.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private UserRole role;


    public UserDto getDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setEmail(email);
        userDto.setRole(role);

        return userDto;
    }
}
