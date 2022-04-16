
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
@Table(name="Articulo")
public class Articulo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private long idArticulo;
    
    private String descripcion;
    private Double precio;
    private int activo;
    private int existencia;
    
    public Articulo() {
        
    }

    public Articulo(long idArticulo, String descripcion, Double precio, int activo, int existencia) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
        this.existencia = existencia;
    }

    
}
