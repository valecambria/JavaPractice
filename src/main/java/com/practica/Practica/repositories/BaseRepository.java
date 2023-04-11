package com.practica.Practica.repositories;

import com.practica.Practica.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean //hace que no pueda crear instancias en este repositorio
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {

}
