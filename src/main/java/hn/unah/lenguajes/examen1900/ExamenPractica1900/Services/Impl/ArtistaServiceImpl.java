package hn.unah.lenguajes.examen1900.ExamenPractica1900.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Artista;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Canciones;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Direccion;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Repositories.ArtistaRepository;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Repositories.CancionesRepository;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Repositories.DireccionRepository;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Services.ArtistaService;

@Service
public class ArtistaServiceImpl implements ArtistaService{
    
    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private CancionesRepository cancionesRepository;

    @Override
    public Artista crearArtista(Artista artista) {
        return this.artistaRepository.save(artista);
    }

    @Override
    public String eliminarArtista(int codigoArtista) {
        if (this.artistaRepository.existsById(codigoArtista)) {
            Artista artista = this.artistaRepository.findById(codigoArtista).get();
            this.artistaRepository.delete(artista);
            return "Artista eliminado";
        }
        return "El artista no existe";
    }

    @Override
    public String actualizarDireccionArtista(Direccion direccion, int codigoArtista) {
        if (this.artistaRepository.existsById(codigoArtista)) {
            Artista artistaActualizar = this.artistaRepository.findById(codigoArtista).get();

            Direccion nvaDireccion = artistaActualizar.getDireccion();
            nvaDireccion.setDepartamento(direccion.getDepartamento());
            nvaDireccion.setCiudad(direccion.getCiudad());
            nvaDireccion.setCalle(direccion.getCalle());

            this.direccionRepository.save(nvaDireccion);
            
            return "Direccion del artista actualizada";
        }
        return "El artista no existe";
    }

    @Override
    public Artista buscarArtistaPorCodigo(int codigoArtista) {
        return this.artistaRepository.findById(codigoArtista).get();
    }

    @Override
    public List<Artista> obtenerArtistas() {
        return (List<Artista>) this.artistaRepository.findAll();
    }

    @Override
    public Artista obtenerArtistaPorNombreCancion(String titulo) {
        List<Canciones> canciones = (List<Canciones>) this.cancionesRepository.findAll();
        for (Canciones cancion : canciones) {
            if (cancion.getTitulo().equals(titulo)) {
                Artista artista = cancion.getArtista();
                return artista;
            }
        }
        return null;
    }

    @Override
    public String asociarCancionArtista(int codigoArtista, int codigoCancion) {
        if (this.artistaRepository.existsById(codigoArtista)) {
            if (this.cancionesRepository.existsById(codigoCancion)) {
                Artista artista = this.artistaRepository.findById(codigoArtista).get();
                Canciones cancion = this.cancionesRepository.findById(codigoCancion).get();
                
                cancion.setArtista(artista);
                this.cancionesRepository.save(cancion);
                return "Cancion asociada con exito";
            }
            return "La cancion no existe";
        };
        return "El artista no existe";
    }
}
