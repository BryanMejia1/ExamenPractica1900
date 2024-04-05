package hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="canciones")
@Data
public class Canciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigocancion")
    private int codigoCancion;

    private String titulo;

    private String album;

    @Column(name="anyolanzamiento")
    private int anyoLanzamiento;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "codigoartista", referencedColumnName = "codigoartista")
    private Artista artista;
}
