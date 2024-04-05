package hn.unah.lenguajes.examen1900.ExamenPractica1900.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Canciones;

@Repository
public interface CancionesRepository extends CrudRepository<Canciones, Integer> {
    
}
