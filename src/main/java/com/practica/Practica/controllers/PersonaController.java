package com.practica.Practica.controllers;

import com.practica.Practica.entities.Persona;
import com.practica.Practica.services.PersonaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") //desde cualquier origen voy a poder acceder a los datos de mi API
@RequestMapping(path="api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

}
