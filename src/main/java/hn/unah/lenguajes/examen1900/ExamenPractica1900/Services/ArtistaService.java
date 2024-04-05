package hn.unah.lenguajes.examen1900.ExamenPractica1900.Services;

import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Artista;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Direccion;
import java.util.List;

public interface ArtistaService {
    
    public Artista crearArtista(Artista artista);

    public String eliminarArtista(int codigoArtista);

    public String actualizarDireccionArtista(Direccion direccion, int codigoArtista);

    public Artista buscarArtistaPorCodigo(int codigoArtista);

    public List<Artista> obtenerArtistas();

    public Artista obtenerArtistaPorNombreCancion(String titulo);

    public String asociarCancionArtista(int codigoArtista, int codigoCancion);
}
