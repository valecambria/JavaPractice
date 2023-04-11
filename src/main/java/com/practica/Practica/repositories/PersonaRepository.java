package com.practica.Practica.repositories;

import com.practica.Practica.entities.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository  extends BaseRepository<Persona, Long> {

}
