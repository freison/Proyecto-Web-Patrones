
package com.proyecto.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Anuncio")
public class Anuncio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_anuncio")
    private long idAnuncio;
    
    private String descripcion;
    private String enlace;
    
    @JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario usuario;
    
    public Anuncio() {
        
    }

    public Anuncio(long idAnuncio, String descripcion, String enlace) {
        this.idAnuncio = idAnuncio;
        this.descripcion = descripcion;
        this.enlace = enlace;
    }

    
}
