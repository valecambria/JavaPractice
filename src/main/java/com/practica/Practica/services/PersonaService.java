package com.practica.Practica.services;

import com.practica.Practica.entities.Persona;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long> {

    List<Persona> search(String filtro) throws Exception;
}
