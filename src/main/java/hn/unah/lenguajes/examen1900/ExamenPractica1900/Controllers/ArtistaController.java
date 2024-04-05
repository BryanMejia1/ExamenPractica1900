package hn.unah.lenguajes.examen1900.ExamenPractica1900.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Artista;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Direccion;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Services.Impl.ArtistaServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/artista")

public class ArtistaController {
    
    @Autowired
    private ArtistaServiceImpl artistaServiceImpl;

    @PostMapping("/crearArtista")
    public Artista crearArtista(@RequestBody Artista artista) {
        return this.artistaServiceImpl.crearArtista(artista);
    }

    @DeleteMapping("/eliminarArtista/{codigoArtista}")
    public String eliminarArtista(@PathVariable int codigoArtista) {
        return this.artistaServiceImpl.eliminarArtista(codigoArtista);
    }

    @PutMapping("actualizarDireccionArtista/{codigoArtista}")
    public String actualizarDireccionArtista(@PathVariable int codigoArtista, 
                                             @RequestBody Direccion direccion) {
        return this.artistaServiceImpl.actualizarDireccionArtista(direccion, codigoArtista);
    }
    
    @GetMapping("/buscarArtistaPorCodigo")
    public Artista buscarArtistaPorCodigo(@RequestParam(name="codigoartista") int codigoArtista) {
        return this.artistaServiceImpl.buscarArtistaPorCodigo(codigoArtista);
    }

    @GetMapping("/obtenerArtistas")
    public List<Artista> obtenerArtistas() {
        return this.artistaServiceImpl.obtenerArtistas();
    }
    
    @GetMapping("/obtenerArtistaPorTitulo")
    public Artista obtenerArtistasPorTitulo(@RequestParam(name="titulo") String titulo) {
        return this.artistaServiceImpl.obtenerArtistaPorNombreCancion(titulo);
    }
    
    @PutMapping("/asociaciarCancionArtista/{codigoArtista}/{codigoCancion}")
    public String putMethodName(@PathVariable int codigoArtista, 
                                @PathVariable int codigoCancion) {
        return this.artistaServiceImpl.asociarCancionArtista(codigoArtista, codigoCancion);
    }
}
