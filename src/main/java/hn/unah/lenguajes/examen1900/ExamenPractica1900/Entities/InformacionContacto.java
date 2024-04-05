package hn.unah.lenguajes.examen1900.ExamenPractica1900.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="informacioncontacto")
@Data
public class InformacionContacto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigocontacto")
    private int codigoContacto;

    private String pais;

    private String ciudad;

    private String telefono;

    private String correo;

    @JsonIgnore
    @OneToOne(mappedBy = "informacioncontacto")
    private Artista artista;
}
