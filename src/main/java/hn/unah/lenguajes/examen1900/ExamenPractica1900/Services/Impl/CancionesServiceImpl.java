package hn.unah.lenguajes.examen1900.ExamenPractica1900.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Artista;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Canciones;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Repositories.ArtistaRepository;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Repositories.CancionesRepository;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Services.CancionesService;

@Service
public class CancionesServiceImpl implements CancionesService{

    @Autowired
    private CancionesRepository cancionesRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public String eliminarCancion(int codigoCancion) {
        if (this.cancionesRepository.existsById(codigoCancion)) {
            Canciones cancion = this.cancionesRepository.findById(codigoCancion).get();
            this.cancionesRepository.delete(cancion);
            return "Cancion eliminada";
        };
        return "La cancion no existe";
    }

    @Override
    public List<Canciones> obtenerCancionesPorArtista(int codigoArtista) {
        Artista artista = this.artistaRepository.findById(codigoArtista).get();
        List<Canciones> canciones = artista.getCanciones();
        return canciones;
    }

    @Override
    public Canciones crearCancion(Canciones cancion) {
        return this.cancionesRepository.save(cancion);
    }  
        
    }
    
    

