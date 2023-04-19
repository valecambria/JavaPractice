package com.practica.Practica.repositories;

import com.practica.Practica.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository  extends BaseRepository<Persona, Long> {

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido); //metodo de query

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);
    //boolean existsByDni(int dni);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%") //anotacion de jpa repository, le asigno un valor que es igual a la consulta jpql .
        // Con esto indico que a persona la voy a llamar por p y voy a encontrar a todas las personas que se encuentren en la base de datos.
    //Llamo al atributo nombre de persona y digo que esto va a ser igual al parametro que paso en el List, para ello entre %% pongo el numero de posicion del parametro.
    List<Persona> search(@Param("filtro") String filtro);
    //Puedo utilizar la anotacion @Param para pasarle el nombre que va a tener el parametro y asi usarlo en la consulta jpql en vez de utilizar el numero de posicion.

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true //indico que es una query nativa que se va a hacer con sql
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true //indico que es una query nativa que se va a hacer con sql
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
