package hn.unah.lenguajes.examen1900.ExamenPractica1900.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities.Canciones;
import hn.unah.lenguajes.examen1900.ExamenPractica1900.Services.Impl.CancionesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/canciones")
public class CancionesController {
    
    @Autowired
    private CancionesServiceImpl cancionesServiceImpl;

    @DeleteMapping("/eliminarCancion")
    public String eliminarCancion(@RequestParam(name="codigocancion") int codigoCancion){
        return this.cancionesServiceImpl.eliminarCancion(codigoCancion);
    }

    @GetMapping("/obtenerCancionesPorArtista")
    public List<Canciones> obtenerCancionesPorArtista(@RequestParam(name="codigoartista") int codigoArtista) {
        return this.cancionesServiceImpl.obtenerCancionesPorArtista(codigoArtista);
    }

    @PostMapping("/crearCancion")
    public Canciones crearCancion(@RequestBody Canciones cancion) {
       return this.cancionesServiceImpl.crearCancion(cancion);
    }
    
    
}
