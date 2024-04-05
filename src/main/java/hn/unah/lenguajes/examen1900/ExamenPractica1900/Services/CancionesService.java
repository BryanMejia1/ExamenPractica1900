package hn.unah.lenguajes.examen1900.ExamenPractica1900.Services;

import java.util.List;

import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Canciones;

public interface CancionesService {
    
    public String eliminarCancion(int codigoCancion);

    public List<Canciones> obtenerCancionesPorArtista(int codigoArtista);

    public Canciones crearCancion(Canciones cancion);
}
