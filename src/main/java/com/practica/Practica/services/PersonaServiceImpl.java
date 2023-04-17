package com.practica.Practica.services;

import com.practica.Practica.entities.Persona;
import com.practica.Practica.repositories.BaseRepository;
import com.practica.Practica.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro); //paso 2 veces, una para nombre y otra para apellido;
            List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
